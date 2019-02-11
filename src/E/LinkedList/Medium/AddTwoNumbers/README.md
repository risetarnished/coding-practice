<!----- Conversion time: 0.941 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Sun Feb 10 2019 23:44:55 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1rcnY3rZUR1BOpA0MI3l4IgEzX-wCCCTjVWJGUAfLYzg
----->



# Add Two Numbers

[https://app.laicode.io/app/problem/223](https://app.laicode.io/app/problem/223)

[https://leetcode.com/problems/add-two-numbers/](https://leetcode.com/problems/add-two-numbers/)


## Description

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

**Example**

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

Medium

Linked List


## Assumption

The list should be a singly linked list with no cycles. When the last two nodes add up to an integer that is greater than 10, an extra node is needed for the carried next digit.


## Algorithm

The two linked lists will move at the same pace such that we can always add the correct corresponding digits. When there is a result that is greater than 10, we need to inform the next digit that there is a carry happened in the previous step.

Special care should be taken when the two linked lists are different in length.


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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    // Create a linked list to store the result
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    // A flag indicating whether a carry should be taken
    boolean needsCarry = false;
    // The two linked lists move at the same pace
    // So the correct corresponding digits will be added
    while (l1 != null && l2 != null) {
      int value = l1.value + l2.value;
      // If there was a carry, add it to the value
      value = needsCarry ? value + 1 : value;
      // If the value is greater than 10
      // We need to carry it to the next digit
      needsCarry = value >= 10;
      value = needsCarry ? value - 10 : value;
      curr.next = new ListNode(value);
      curr = curr.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    // Post-processing
    // When the two linked lists have different length
    // Continue adding the longer list to the result
    while (l1 != null) {
      int value = needsCarry ? l1.value + 1 : l1.value;
      // Set the carry flag for the next digit
      needsCarry = value >= 10;
      // Update the value
      value = needsCarry ? value - 10 : value;
      // Ready to be added to the result
      curr.next = new ListNode(value);
      curr = curr.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int value = needsCarry ? l2.value + 1 : l2.value;
      // Set the carry flag for the next digit
      needsCarry = value >= 10;
      // Update the value
      value = needsCarry ? value - 10 : value;
      // Ready to be added to the result
      curr.next = new ListNode(value);
      curr = curr.next;
      l2 = l2.next;
    }
    // Post-processing
    // When the last addition yields a carry
    if (needsCarry) {
      curr.next = new ListNode(1);
    }
    return dummy.next;
  }
}
```



### Complexity


#### Time

We need to iterate over the entire linked lists exactly once ⇒ O(n)


#### Space

Only variables with constant space get created ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
