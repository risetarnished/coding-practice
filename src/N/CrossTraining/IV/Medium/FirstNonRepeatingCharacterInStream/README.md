# First Non-Repeating Character in Stream

[https://app.laicode.io/app/problem/288](https://app.laicode.io/app/problem/288)

## Description

Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character **in O(1) time** at any moment.

Implement two methods of the class:

- read() - read one character from the stream
- firstNonRepeating() - return the first non-repeating character from the stream at any time when calling the method, return null if there does not exist such characters

**Examples:**

read:

a   b   c   a   c   c    b

firstNonRepeating:

a   a   a   b   b   b   null

**Tags**

- Medium
- Hashtable
- Linked List

## Assumption

- The input is a *stream of characters*

## Solution

### High-level Idea

- Required O(1) time retrieving the result at any time
- This is pretty much like an *LRU cache*
- E.g., input: \[a, b, c, d, a, c, c, b], use *some data structure* to store the non-repeating characters read so far
  - input: \[**a**]
    - data structure: \[**a**]
    - result: \[**a**]
  - input: \[a **b**]
    - data structure: \[a **b**]
    - result: \[a **a**]
  - input: \[a b **c**]
    - data structure: \[a b **c**]
    - result: \[a a **a**]
  - input: \[a b c **d**]
    - data structure: \[a b c **d**]
    - result: \[a a a **a**]
  - input: \[a b c d **a**]
    - data structure: \[~~**a**~~ b c d **a**]
    - result: \[a a a a **b**]
  - input: \[a b c d a **c**]
    - data structure: \[b **~~c~~** d a **c**]
    - result: \[a a a a b **b**]
  - input: \[a b c d a c **c**]
    - data structure: \[b d a **~~c~~** **c**]
    - result: \[a a a a b b **b**]
  - input: \[a b c d a c c **b**]
    - data structure: \[**~~b~~** d a c **b**]
    - result: \[a a a a b b b **d**]
- The data structure should have features like
  - when a new element comes in, **insertEnd()**
  - when an existing element is seen again, **remove()**
    - cut it off from its proceeder and successor
    - link them together
  - *all of these indicates something like a **doubly linked list***
- Use a map to speed up the look up process

### Code

```java
public class Solution {
  /**
   * Node objects are used to create a doubly-linked list of the characters
   */
  private static class Node {
    Character ch;
    Node prev;
    Node next;
    
    Node(Character ch) {
      this.ch = ch;
    }
  }
  
  /**
   * Keep track of the head and tail pointers all the time
   * The doubly-linked list represents the unique characters read so far
   * With the head representing the first unique character and the tail
   * representing the latest one
   */
  private Node head;
  private Node tail;
  
  /**
   * Maintain a map to record the relationship between
   * <character, # of appearance>
   * If the appearance > 1, this element has been seen more than once before
   * If the appearance == 1, this element is unique
   */
  private Map<Character, Integer> freq;
  
  /**
   * Maintain another map to record the relationship between
   * <character, corresponding node>
   * This speeds up looking up the node in the doubly-linked list
   */
  private Map<Character, Node> map;
  
  public Solution() {
    // Initialize the class.
    head = tail = null;
    freq = new HashMap<>();
    map = new HashMap<>();
  }
  
  public void read(char ch) {
    // Implement this method here.
    // Ignore the character if is repeating
    int frequency = freq.getOrDefault(ch, 0);
    if (frequency > 1) {
      freq.put(ch, frequency + 1);
      return;
    }
    // Fetch the corresponding node
    Node node = map.get(ch);
    if (node == null) {
      // If the character has not been seen before
      // Add it to the list and create an entry in freq
      node = new Node(ch);
      append(node);
    } else {
      // If the character has been seen and is unique
      // Remove it from the list and increment its frequency
      remove(node);
      freq.put(node.ch, frequency + 1);
    }
  }
  
  public Character firstNonRepeating() {
    // Implement this method here.
    if (head == null) {
      return null;
    }
    return head.ch;
  }
  
  /**
   * Add the node to the end of the list such that it is represented as
   * the latest unique character read
   * Add an entry of the node's character and the node to the map
   *
   * @param node The node that is being added
   */
  private void append(Node node) {
    if (head == null) {
      head = tail = node;
    } else {
      // Append the node to the end of the list and update the tail pointer
      node.prev = tail;
      tail.next = node;
      tail = node;
    }
    // Create an entry for the character and node in the map
    map.put(node.ch, node);
    freq.put(node.ch, 1);
  }
  
  /**
   * Remove a node from the doubly-linked list
   *
   * @param node The node to be removed
   */
  private void remove(Node node) {
    // 4 conditions
    // 1. The node is the only node in the list
    // 2. The node is the head of the list
    // 3. The node is the tail of  the list
    // 4. The node is in the middle of the list
    if (node == head && node == tail) {
      head = tail = null;
    } else if (node == head) {
      head = head.next;
      node.next = null;
      head.prev = null;
    } else if (node == tail) {
      tail = tail.prev;
      node.prev = null;
      tail.next = null;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.prev = null;
      node.next = null;
    }
  }
}
```

### Complexity

- Time
  - Because of the nature of the data structure used
    - Insert/add/delete/remove operations on doubly-linked lists and hash maps are all amortized O(1)
  - The time complexity of the read() and firstNonRepeating() methods are both O(1)
- Space
  - Two hash maps of size n are maintained
  - A doubly-linked list of size n is maintained
  - Total space is O(3n) = O(n)
  