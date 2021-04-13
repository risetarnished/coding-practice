package coollime.linkedlist.middlenodeoflinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiddleNodeOfLinkedListTest {

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
  void shouldReturnNullWhenTheListIsEmpty() {
    ListNode result = sut.middleNode(head);
    assertEquals(null, result);
  }

  @Test
  void shouldReturnTheHeadWhenThereIsOnlyOneNode() {
    head = new ListNode(0);
    ListNode result = sut.middleNode(head);
    assertEquals(head, result);
  }

  @Test
  void shouldReturnTheFirstMiddleNodeWhenThereAreEvenNumberOfNodes() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2)));
    ListNode middle = sut.middleNode(head);
    assertEquals(head, middle);

    head = ListNode.buildList(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1, 0)));
    middle = sut.middleNode(head);
    // Expected output ==> node3
    assertEquals(head.next.next, middle);
  }

  @Test
  void shouldReturnTheMiddleNodeWhenThereAreOddNumberOfNodes() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
    ListNode middle = sut.middleNode(head);
    assertEquals(head.next, middle);
  }
}
