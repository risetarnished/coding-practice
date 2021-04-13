package coollime.linkedlist.addtwonumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {

  private static Solution sut;
  private ListNode l1, l2;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    l1 = null;
    l2 = null;
  }

  @Test
  void shouldReturnEitherListWhenTheOtherOneIsEmpty() {
    assertEquals(l2, sut.addTwoNumbers(l1, l2));
    l1 = new ListNode(0);
    assertEquals(l1, sut.addTwoNumbers(l1, l2));
  }

  @Test
  void shouldAddNumbersInTheTwoLists() {
    l1 = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 4, 3)));
    l2 = ListNode.buildList(new ArrayList<>(Arrays.asList(5, 6, 4)));
    assertEquals(
      ListNode.buildList(new ArrayList<>(Arrays.asList(7, 0, 8))),
      sut.addTwoNumbers(l1, l2)
    );

    l1 = ListNode.buildList(new ArrayList<>(Arrays.asList(9, 8)));
    l2 = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 1)));
    assertEquals(
      ListNode.buildList(new ArrayList<>(Arrays.asList(0, 0, 1))),
      sut.addTwoNumbers(l1, l2)
    );

    l1 = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
    l2 = ListNode.buildList(new ArrayList<>(Arrays.asList(7, 8, 9)));
    assertEquals(
      ListNode.buildList(new ArrayList<>(Arrays.asList(8, 0, 3, 1))),
      sut.addTwoNumbers(l1, l2)
    );
  }
}
