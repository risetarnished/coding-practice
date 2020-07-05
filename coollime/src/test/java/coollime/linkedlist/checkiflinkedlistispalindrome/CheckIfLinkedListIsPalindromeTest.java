package coollime.linkedlist.checkiflinkedlistispalindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.helper.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckIfLinkedListIsPalindromeTest {
  private static Solution sut;
  private ListNode head;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    head = null;
  }

  @Test
  void shouldReturnTrueWhenTheListIsEmpty() {
    assertTrue(sut.isPalindrome(head));
  }

  @Test
  void shouldReturnTrueWhenThereIsOnlyOneNode() {
    head = new ListNode(0);
    assertTrue(sut.isPalindrome(head));
  }

  @Test
  void shouldReturnTrueWhenTheListIsAPalindrome() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1)));
    assertTrue(sut.isPalindrome(head));
  }

  @Test
  void shouldReturnFalseWhenTheListIsNotAPalindrome() {
    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
    assertFalse(sut.isPalindrome(head));

    head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 1)));
    assertFalse(sut.isPalindrome(head));
  }
}
