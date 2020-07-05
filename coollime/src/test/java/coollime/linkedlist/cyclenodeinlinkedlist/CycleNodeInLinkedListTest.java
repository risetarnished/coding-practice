package coollime.linkedlist.cyclenodeinlinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import coollime.helper.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CycleNodeInLinkedListTest {
  private static Solution sut;
  private ListNode head;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    head = null;
  }

  @Test
  void shouldNotFindTheNodeWhenTheListIsEmpty() {
    assertNull(sut.cycleNode(head));
  }

  @Test
  void shouldReturnTheHeadNodeWhenThereIsOnlyOneNode() {
    head = new ListNode(0);
    assertNull(sut.cycleNode(head));
  }

  @Test
  void shouldReturnTheCycleNode() {
    head =
      ListNode.buildCycleList(new ArrayList<>(Arrays.asList(3, 2, 0, -4)), 1);
    assertEquals(2, sut.cycleNode(head).value);

    head = ListNode.buildList(new ArrayList<>(Arrays.asList(3, 2, 0, -4)));
    assertNull(sut.cycleNode(head));
  }
}
