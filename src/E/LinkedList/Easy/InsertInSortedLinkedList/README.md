<!----- Conversion time: 1.733 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 19:55:45 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1oKTaFeh19icFXuNC2stf5PAeT7-hVgFhF9UzwIFKC1s
----->



# Insert In Sorted Linked List

[https://app.laicode.io/app/problem/39](https://app.laicode.io/app/problem/39)


## Description


    Insert a value in a sorted linked list.


    Examples



*   L = null, insert 1, return 1 -> null
*   L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
*   L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
*   L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null




Easy

Linked List


## Assumption

The input node should not be null.


## Algorithm

There are basically two cases:



1.  insert before the head (head == null || head.value >= value)
1.  insert into the middle or after the tail: the most important point is to check current.next.val instead of just current.val




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
  public ListNode insert(ListNode head, int value) {
    // Write your solution here
    // Case 1: insert before the head (new node becomes the new head)
    ListNode newNode = new ListNode(value);
    if (head == null || head.value >= value) {
      newNode.next = head;
      return newNode;
    }
    // Case 2: insert in the middle or tail
    ListNode current = head;
    // Skip all the nodes whose values are less than (NOT equal to) value
    while (current.next != null && current.next.value < value) {
      current = current.next;
    }
    // Two situations now:
    // 1. current.value < value <= current.next.value
    // 2. current is tail
    // In either case, insert the new node after current
    newNode.next = current.next;
    current.next = newNode;
    return head;
  }
}
```



### Complexity

Time: traversing the entire linked list ⇒ O(n).

Space: constant space ⇒ O(1).


<!-- GD2md-html version 1.0β13 -->
