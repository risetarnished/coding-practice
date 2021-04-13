package coollime.linkedlist.mergesortlinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSortLinkedListTest {

  private static Solution sut;
  private ListNode head;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    head = null;
  }

  @Test
  void shouldNotSortTheListWhenItIsEmpty() {
    assertEquals(head, sut.sortList(head));
  }

  @Test
  void shouldNotSortTheListWhenThereIsOnlyOneNode() {
    head = new ListNode(1);
    assertEquals(head, sut.sortList(head));
  }

  @Test
  void shouldSortTheLinkedList() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
    assertEquals(
      ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3))),
      sut.sortList(head)
    );

    head = ListNode.buildList(new ArrayList<>(Arrays.asList(4, 2, 6, -3, 5)));
    assertEquals(
      ListNode.buildList(new ArrayList<>(Arrays.asList(-3, 2, 4, 5, 6))),
      sut.sortList(head)
    );
  }
}
