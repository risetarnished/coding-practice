package coollime.linkedlist.insertinsortedlinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.helper.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertInSortedLinkedListTest {
  private static Solution sut;
  private ListNode head;
  private int value;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    head = null;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldInsertNewNodeWhenTheListIsEmpty() {
    value = 0;
    ListNode result = sut.insert(head, value);
    assertEquals(new ListNode(value), result);
  }

  @Test
  void shouldInsertInTheMiddleOfTheList() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    value = 4;
    ListNode result = sut.insert(head, value);
    ListNode expected = ListNode.buildList(
      new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 5, 6))
    );
    assertEquals(expected, result);
  }

  @Test
  void shouldInsertAfterTheTail() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    value = 7;
    ListNode result = sut.insert(head, value);
    ListNode expected = ListNode.buildList(
      new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
    );
    assertEquals(expected, result);
  }
}
