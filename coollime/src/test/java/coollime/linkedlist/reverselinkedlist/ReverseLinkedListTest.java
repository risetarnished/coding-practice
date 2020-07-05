package coollime.linkedlist.reverselinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.helper.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {
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
  void shouldNotReverseWhenTheListIsEmpty() {
    ListNode iterativeResult = sut.reverse(head);
    assertEquals(head, iterativeResult);

    ListNode recursiveResult = sut.reverseRecursively(head);
    assertEquals(head, recursiveResult);
  }

  @Test
  void shouldNotReverseWhenThereIsOnlyOneNode() {
    head = new ListNode(0);
    ListNode iterativeResult = sut.reverse(head);
    assertEquals(head, iterativeResult);

    ListNode recursiveResult = sut.reverseRecursively(head);
    assertEquals(head, recursiveResult);
  }

  @Test
  void shouldReverseTheLinkedList() {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    head = ListNode.buildList(nodes);
    Collections.reverse(nodes);
    ListNode expected = ListNode.buildList(nodes);

    ListNode iterativeResult = sut.reverse(head);
    assertEquals(expected, iterativeResult);

    // Restore the nodes and build it again to retain to original linked list
    Collections.reverse(nodes);
    head = ListNode.buildList(nodes);
    ListNode recursiveResult = sut.reverseRecursively(head);
    assertEquals(expected, recursiveResult);
  }
}
