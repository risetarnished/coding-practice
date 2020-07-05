# Merge Sort Linked List

[https://app.laicode.io/app/problem/29](https://app.laicode.io/app/problem/29)

## Description

Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

- null, is sorted to null
- 1 -> null, is sorted to 1 -> null
- 1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
- 4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6

Medium

Linked List

Sort

Two Pointers

## Assumption

The linked list is singly-linked and should not be null or empty. Nor should it have cycles in it.

## Algorithm

The merge sort algorithm can be perfectly fit to solve this problem. The basic idea in a high level point of view is to divide the linked list into two parts each time and recursively sort the two parts. After the divided linked lists are sorted accordingly, we merge them together based on the principle of "move the smaller one".

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

  public ListNode mergeSort(ListNode head) {
    // Write your solution here
    // Corner cases
    if (head == null || head.next == null) {
      return head;
    }
    // Divide the linked list into two parts evenly
    ListNode mid = findMiddleNode(head);
    ListNode secondPart = mid.next;
    // Cut the first part from the second part
    mid.next = null;
    // Recursively sort the divided lists
    ListNode sortedFirst = mergeSort(head);
    ListNode sortedSecond = mergeSort(secondPart);
    // Merge the sorted linked lists together
    return mergeLists(sortedFirst, sortedSecond);
  }

  private ListNode findMiddleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // Fast-slow pointers method
    // Return the first node if there are two middle nodes
    // in a linked list with an even length
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode mergeLists(ListNode one, ListNode two) {
    if (one == null) {
      return two;
    } else if (two == null) {
      return one;
    }
    // Create a new linked list to store the result
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (one != null && two != null) {
      if (one.value < two.value) {
        curr.next = one;
        one = one.next;
      } else {
        curr.next = two;
        two = two.next;
      }
      curr = curr.next;
    }
    // Post-processing of any left-over elements in either list
    if (one != null) {
      curr.next = one;
    } else if (two != null) {
      curr.next = two;
    }
    return dummy.next;
  }
}
```

### Complexity

#### Time

The linked lists are divided by ½ each time, so there are log(n) levels in the call stack. In each level, finding the middle node of the list takes O(n) time. So does the merge process. Therefore, the total time complexity is O(n log(n)).

#### Space

Because there are log(n) levels in the recursion tree/call stack, and only variables/objects with constant spaces are created in each level. The total space complexity is O(log(n)).
