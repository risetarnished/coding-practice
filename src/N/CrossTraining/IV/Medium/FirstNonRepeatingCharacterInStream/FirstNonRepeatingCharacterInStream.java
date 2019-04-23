package N.CrossTraining.IV.Medium.FirstNonRepeatingCharacterInStream;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInStream {
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

  public FirstNonRepeatingCharacterInStream() {
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
