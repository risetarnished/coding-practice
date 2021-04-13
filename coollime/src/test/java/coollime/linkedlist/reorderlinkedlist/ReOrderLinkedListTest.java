package coollime.linkedlist.reorderlinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReOrderLinkedListTest {

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
  void shouldNotReOrderWhenTheListIsEmpty() {
    ListNode result = sut.reorder(head);
    assertEquals(head, result);
  }

  @Test
  void shouldNotReOrderWhenThereIsOnlyOneNode() {
    head = new ListNode(0);
    ListNode result = sut.reorder(head);
    assertEquals(head, result);
  }

  @Test
  void shouldReOrderList() {
    // 1 -> 2 -> 3 -> 4 -> null => 1 -> 4 -> 2 -> 3 -> null
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
    ListNode result = sut.reorder(head);
    ListNode expected = ListNode.buildList(
      new ArrayList<>(Arrays.asList(1, 4, 2, 3))
    );
    assertEquals(expected, result);

    // 1 -> 2 -> 3 -> null => 1 -> 3 -> 2 -> null
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
    result = sut.reorder(head);
    expected = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 3, 2)));
    assertEquals(expected, result);

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null =>
    // 1 -> 10 -> 2 -> 9 -> 3 -> 8 -> 4 -> 7 -> 5 -> 6 -> null
    head =
      ListNode.buildList(
        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
      );
    result = sut.reorder(head);
    expected =
      ListNode.buildList(
        new ArrayList<>(Arrays.asList(1, 10, 2, 9, 3, 8, 4, 7, 5, 6))
      );
    assertEquals(expected, result);
  }
}
