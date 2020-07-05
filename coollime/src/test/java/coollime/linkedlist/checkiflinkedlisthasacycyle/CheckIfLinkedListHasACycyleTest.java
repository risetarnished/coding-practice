package coollime.linkedlist.checkiflinkedlisthasacycyle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.helper.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckIfLinkedListHasACycyleTest {
  private static Solution sut;
  private ListNode head;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    head = null;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldReturnFalseWhenTheLinkedListIsNull() {
    assertFalse(sut.hasCycle(head));
  }

  @Test
  void shouldReturnFalseWhenTheListHasOnlyOneNode() {
    head = new ListNode(0);
    assertFalse(sut.hasCycle(head));
  }

  @Test
  void shouldReturnTrueWhenThereIsACycle() {
    // Build a linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 5 ---> 2
    head = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);
    head.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    five.next = two;
    assertTrue(sut.hasCycle(head));
  }

  @Test
  void shouldReturnFalseWhenThereAreNoCycles() {
    // Build a linked list without a cycle: 1 -> 2 -> 3 -> 4 -> 5
    head = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);
    head.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    assertFalse(sut.hasCycle(head));
  }
}
