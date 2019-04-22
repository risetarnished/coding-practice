# Implement LRU Cache

[https://app.laicode.io/app/problem/205](https://app.laicode.io/app/problem/205)

## Description

Implement a **least recently used cache**. It should provide *set()*, *get()* operations. If not exists, return null (Java), false (C++), -1(Python).

**Tags**

- Medium
- Hashtable
- Heap
- Linked List

## Assumption

- The key and value are provided with generic types K and V

## Solution

### High-level Idea

- E.g., K - query, V - response
  - Given <K1, V1>, <K2, V2>, ..., <K5000, V5000>
  - Use a data structure to store the <K, V> pairs such that
    - Whenever <Kk, Vk> is called
      - it can be appended to the end of the cache
      - the oldest pair, <K1, V1> can be removed from the cache
    - Looks like a doubly linked list can be a good fit
  - Use a map to speed up the look-up process
    - The linked list stores ListNode objects with <K, V> pairs
    - The map stores the <K, ListNode>

### Code

```java
public class Solution<K, V> {
  // A Node object represents a <K, V> pair
  // which has a next as well as a prev pointer
  private static class Node<K, V> {
    Node<K, V> next;
    Node<K, V> prev;
    K key;
    V val;
    
    Node(K key, V val) {
      this.key = key;
      this.val = val;
    }
  }
  
  // Class variables/data structures declaration
  // Pre-defined limit of the size
  private final int limit;
  // Keep the references of the head and tail pointers all the time
  // Updated time is represented in chronicle order from head to tail
  // where head/tail is the most/least recently used
  private Node<K, V> head;
  private Node<K, V> tail;
  // Maintain the relationship between the key and its corresponding node
  private Map<K, Node<K, V>> map;
  
  // limit is the max capacity of the cache
  public Solution(int limit) {
    this.limit = limit;
    this.map = new HashMap<>();
  }
  
  public void set(K key, V value) {
    Node<K, V> node = null;
    if (map.containsKey(key)) {
      // 1. If the key is already in the cache, update its value and 
      //    move it to the head
      node = map.get(key);
      node.val = value;
      // Cut the node from its prev and next
      remove(node);
    } else if (map.size() < limit) {
      // 2. If the key is not in the cache, but the cache is not full
      //    simply append it to the head
      node = new Node<K, V>(key, value);
    } else {
      // 3. If the key is not in the cache, and the cache is full
      //    Remove the least recently used item (tail) and append
      //    the new node to the head
      // Reuse the tail node object
      node = tail;
      remove(node);
      node.key = key;
      node.val = value;
    }
    append(node);
  }
  
  public V get(K key) {
    Node<K, V> node = map.get(key);
    if (node == null) {
      return null;
    }
    // A read/touch operation on the node updates the timestamp, too
    remove(node);
    append(node);
    return node.val;
  }
  
  private Node<K, V> remove(Node<K, V> node) {
    // Remove the corresponding map entry
    map.remove(node.key);
    // Cut the node off from its prev and next
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node == head) {
      head = head.next;
    }
    if (node == tail) {
      tail = tail.prev;
    }
    node.next = node.prev = null;
    return node;
  }
  
  private Node<K, V> append(Node<K, V> node) {
    // Add a corresponding map entry of this node
    map.put(node.key, node);
    if (head == null) {
      head = tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
    return head;
  }
}
```

### Complexity

- Time
  - The set(), get(), and the private remove(), append() methods all have operations 
    - insert/delete in linked list
    - add/remove in hash map
    - All of the above are amortized O(1) operations
- Space
  - A HashMap is used
  - O(n)
  