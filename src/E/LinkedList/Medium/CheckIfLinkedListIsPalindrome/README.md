<!----- Conversion time: 1.259 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Feb 11 2019 01:56:44 GMT-0800 (PST)
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



1.  Reverse the linked list
1.  Traverse the original linked list and the reversed linked list
    1.  If, at any point, the two nodes have different values, the original linked list is not palindrome
    1.  If the reversed linked list is the same as the original one, the linked list is palindrome


## Solution


### Code


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



### Complexity


#### Time

Reversing the original list takes O(n).

Comparing the original list and the reversed list takes another O(n) ⇒ O(n)


#### Space

The reversed version of the original list has its own copy of nodes ⇒ O(n)


<!-- Docs to Markdown version 1.0β14 -->
