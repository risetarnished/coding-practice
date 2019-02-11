package E.LinkedList.Medium.CheckIfLinkedListIsPalindrome;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfLinkedListIsPalindromeTest {
    private static CheckIfLinkedListIsPalindrome instance;
    private ListNode head;

    @BeforeAll
    static void setInstance() {
        instance = new CheckIfLinkedListIsPalindrome();
    }

    @BeforeEach
    void setUp() {
        head = null;
    }

    @Test
    void isPalindrome() {
        assertTrue(instance.isPalindrome(head));
        head = new ListNode(0);
        assertTrue(instance.isPalindrome(head));

        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
        assertFalse(instance.isPalindrome(head));

        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1)));
        assertTrue(instance.isPalindrome(head));

        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 1)));
        assertFalse(instance.isPalindrome(head));
    }
}