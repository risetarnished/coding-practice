package N.CrossTraining.IV.Medium.ImplementLRUCache;

import java.util.HashMap;
import java.util.Map;

public class ImplementLRUCache<K, V> {
  /**
   * A Node object represents a <K, V> pair which has a next as well as a prev pointer
   */
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
  /**
   *  Pre-defined limit of the size
   */
  private final int limit;

  // Keep the references of the head and tail pointers all the time
  /**
   * Updated time is represented in chronicle order from head to tail
   * where head/tail is the most/least recently used
   */
  private Node<K, V> head;
  private Node<K, V> tail;

  /**
   * Maintain the relationship between the key and its corresponding node
   */
  private Map<K, Node<K, V>> map;

  // limit is the max capacity of the cache
  /**
   * Constructor
   *
   * @param limit the maximum capacity of the cache
   */
  public ImplementLRUCache(int limit) {
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
