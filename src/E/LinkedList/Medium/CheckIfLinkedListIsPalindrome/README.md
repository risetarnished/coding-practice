<!----- Conversion time: 0.863 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β15
* Fri Feb 15 2019 18:10:49 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1XlAfUEk_UEIoz5WmfBKJP-9v6q63_yrbyizG5A00xKE
----->



# Check if Linked List is Palindrome

[https://app.laicode.io/app/problem/306](https://app.laicode.io/app/problem/306)


## Description

Given a linked list, check whether it is a palindrome.

Examples:

Input:   1 -> 2 -> 3 -> 2 -> 1 -> null

output: true.

Input:   1 -> 2 -> 3 -> null

output: false.

Requirements:

Space complexity must be O(1)

Medium

Linked List


## Assumption

The input linked list should be a non-null, singly-linked list without cycles.


## Algorithm

The high level idea is to implement a method that does what the definition of a "palindrome" does: if a linked list reads the same from its head to tail and from its tail to head, it is a palindrome.



1. O(n) space naive solution
    1. Reverse the linked list
    2. Traverse the original linked list and the reversed linked list
        1. If, at any point, the two nodes have different values, the original linked list is not palindrome
        2. If the reversed linked list is the same as the original one, the linked list is palindrome
2. O(1) space improved solution
    3. Look for the middle node in the linked list
    4. Reverse the second half of the list
        3. if there are **odd** number of nodes in the list, e.g., 1 → 2 → 3 → 2 → 1
            1. reverse(mid) such that
                1. 1st half = 1 → 2 → 3 → null
                2. 2nd half = 1 → 2 → 3 → null
        4. if there are **even** number of nodes in the list, e.g., 1 → 2 → 3 → 4 → 2 → 1
            2. reverse(mid) and mid.next = null such that
                3. 1st half = 1 → 2 → 3 → null
                4. 2nd half = 1 → 2 → 4 → 3  → null
    5. Compare each node of the first half and the reversed second half
        5. if, at any point, the two nodes have different values, the linked list is not palindrome
        6. if the two parts are the same, the linked list is palindrome
        7. It does not matter if there are odd or even number of nodes in the original linked list if we do reverse(mid). The second half will always have the same amount of nodes (odd) or one more node (even) than there are in the first half. In either case, we only need to iterate over the two halves until we finish checking all nodes in the first half. This guarantees that we have checked all nodes in the list.
    6. Reverse the reversed second half back to its original order to restore the original linked list


## Solution


### Method 1


#### Code


```java
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public boolean isPalindrome(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return true;
    }
    // Reverse the list
    ListNode reversed = reverse(head);
    // Compare the two lists
    // head -> tail vs tail -> head in its original position
    while (head != null && reversed != null) {
      if (head.value != reversed.value) {
        return false;
      }
      head = head.next;
      reversed = reversed.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    // The reversed linked list should have its
    // own copy of nodes and should not interfere
    // with the original linked list
    if (head == null) {
      return null;
    } else if (head.next == null) {
      return new ListNode(head.value);
    }
    ListNode reversed = null;
    ListNode prev = null;
    while (head != null) {
      // Make a copy of the original node
      reversed = new ListNode(head.value);
      reversed.next = prev;
      prev = reversed;
      head = head.next;
    }
    return reversed;
  }
}
```



#### Complexity


##### Time

Reversing the original list takes O(n).

Comparing the original list and the reversed list takes another O(n) ⇒ O(n)


##### Space

The reversed version of the original list has its own copy of nodes ⇒ O(n)


### Method 2


#### Code


```java
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public boolean isPalindrome(ListNode head) {
    // Write your solution here
    // Corner cases:
    if (head == null || head.next == null) {
      return true;
    }
    // Step 1: find the middle node of the list
    ListNode mid = findMiddleNode(head);
    // Step 2: reverse the second half of the list
    //         No matter there are odd or even number of nodes
    //         Just do reverse(mid)
    //   case 1: odd number of nodes
    //           first.size() == second.size()
    //   case 2: even number of nodes
    //           first.size() == secon.size() - 1
    ListNode reversedSecond = reverse(mid);
    // Step 3: compare each node in the two halves
    // Exit the while-loop when we have finished comparing
    // all nodes:
    //   case 1: odd number of nodes
    //           Because first.size() == second.size()
    //           first == null && second == null will guarantee
    //           that we have compared all nodes
    //   case 2: even number of nodes
    //           Because first.size() < second.size()
    //           first == null will guarantee that we have
    //           compared all nodes
    ListNode first = head;
    ListNode second = reversedSecond;
    while (first != null && second != null) {
      if (first.value != second.value) {
        // Restore the orginal linked list before returning
        reverse(reversedSecond);
        return false;
      }
      first = first.next;
      second = second.next;
    }
    // Restore the original linked list
    reverse(reversedSecond);
    return true;
  }

  private ListNode findMiddleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
```



#### Complexity


##### Time

Find the middle node of the linked list ⇒ O(n)

Reverse the second half of the linked list ⇒ O(n)

Compare each node in one half against the other ⇒ O(n)

Reverse the second half back to the original order ⇒ O(n)

Therefore, total time complexity is O(n)


##### Space

Unlike Method 1, no new copies of the original linked list were created. All operations are done on the original input linked list. The space complexity is O(1) in this case.


<!-- Docs to Markdown version 1.0β15 -->
