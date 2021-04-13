package coollime.linkedlist.partitionlinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitionLinkedListTest {

  private static Solution sut;
  private ListNode head;
  private int target;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    this.head = null;
    this.target = 0;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotPartitionWhenTheListIsEmpty() {
    ListNode result = sut.partition(head, target);
    assertEquals(head, result);
  }

  @Test
  void shouldNotPartitionWhenThereIsOnlyOneNode() {
    head = new ListNode(0);
    ListNode result = sut.partition(head, target);
    assertEquals(head, result);
  }

  @Test
  void shouldPartitionTheList() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 4, 3, 5, 1)));
    target = 3;
    ListNode result = sut.partition(head, target);
    ListNode expected = ListNode.buildList(
      new ArrayList<>(Arrays.asList(2, 1, 4, 3, 5))
    );
    assertEquals(expected, result);
  }
}
