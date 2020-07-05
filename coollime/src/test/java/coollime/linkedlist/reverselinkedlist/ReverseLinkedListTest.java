package E.LinkedList.Easy.ReverseLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import helper.ListNode.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {
  private static ReverseLinkedList reverseLinkedList;
  private ListNode head;

  @BeforeAll
  static void setInstance() {
    reverseLinkedList = new ReverseLinkedList();
  }

  @BeforeEach
  void setUp() {
    head = null;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void testNull() {
    ListNode result = reverseLinkedList.reverse(head);
    assertEquals(head, result);
  }

  @Test
  void testOneNode() {
    head = new ListNode(0);
    ListNode result = reverseLinkedList.reverse(head);
    assertEquals(head, result);
  }

  @Test
  void test() {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    head = ListNode.buildList(nodes);
    ListNode reversed = reverseLinkedList.reverse(head);
    //        List<Integer> result = ListNode.listToArray(reversed);
    //        assertEquals(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1)), result);
    Collections.reverse(nodes);
    ListNode expected = ListNode.buildList(nodes);
    assertEquals(expected, reversed);
  }
}
