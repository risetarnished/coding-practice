package coollime.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListNode {
  public int value;
  public ListNode next;

  public ListNode(int value) {
    this.value = value;
    next = null;
  }

  /**
   * Build a linked list according to an input list of integers
   *
   * @param nodes  A list of node's keys used to build a linked list sequentially
   * @return       A linked list
   */
  public static ListNode buildList(List<Integer> nodes) {
    if (nodes == null || nodes.isEmpty()) {
      return null;
    }
    ListNode head = new ListNode(nodes.get(0));
    ListNode current = head;
    for (int i = 1; i < nodes.size(); i++) {
      current.next = new ListNode(nodes.get(i));
      current = current.next;
    }
    return head;
  }

  /**
   * Build a linked list with a cycle at a given index
   *
   * @param nodes  A list of node's keys used to build a linked list sequentially
   * @param index  The starting point of the cycle
   */
  public static ListNode buildCycleList(List<Integer> nodes, int index) {
    if (nodes == null || nodes.isEmpty()) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    ListNode start = null;
    for (int i = 0; i < nodes.size(); i++) {
      ListNode newNode = new ListNode(nodes.get(i));
      if (i == index) {
        start = newNode;
      }
      curr.next = newNode;
      curr = curr.next;
    }
    // Linked the tail to the start of the cycle
    curr.next = start;
    return dummy.next;
  }

  /**
   * Output a linked list in the form of a list of integers
   *
   * @param head  The head node of the linked list
   * @return      A list of all the node's keys
   */
  public static List<Integer> listToArray(ListNode head) {
    List<Integer> result = new ArrayList<>();
    if (head == null) {
      return result;
    }
    ListNode current = head;
    while (current != null) {
      result.add(current.value);
      current = current.next;
    }
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListNode)) {
      return false;
    }
    ListNode listNode = (ListNode) o;
    return value == listNode.value && Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, next);
  }
}
