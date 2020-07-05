package coollime.linkedlist.mergetwosortedlinkedlists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.helper.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeTwoSortedLinkedListsTest {
  private static Solution sut;
  private ListNode one, two;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    one = null;
    two = null;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotMergeWhenBothListsAreNull() {
    ListNode result = sut.merge(one, two);
    assertEquals(null, result);
  }

  @Test
  void shouldMergeEitherListWhenTheOtherIsNull() {
    one = new ListNode(0);
    ListNode result = sut.merge(one, two);
    assertEquals(new ListNode(0), result);

    // Reset node one
    one = null;
    two = new ListNode(1);
    result = sut.merge(one, two);
    assertEquals(new ListNode(1), result);
  }

  @Test
  void shouldMergeTwoListsWhenNeitherIsNull() {
    one = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 4, 6)));
    two = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 5)));
    ListNode result = sut.merge(one, two);
    ListNode expected = ListNode.buildList(
      new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6))
    );
    assertEquals(expected, result);

    one = ListNode.buildList(new ArrayList<>(Arrays.asList(0, 5, 5, 5, 8, 10)));
    two = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 3, 4, 4, 5, 7)));
    result = sut.merge(one, two);
    expected =
      ListNode.buildList(
        new ArrayList<>(Arrays.asList(0, 2, 3, 4, 4, 5, 5, 5, 5, 7, 8, 10))
      );
    assertEquals(expected, result);
  }
}
