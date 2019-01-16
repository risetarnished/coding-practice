<!----- Conversion time: 0.72 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 19:50:58 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1clXbTROoX1eImLApW5sq538ZO_yjc6Jq5s5JsloDaR4
----->



# Middle Node of Linked List

[https://app.laicode.io/app/problem/36](https://app.laicode.io/app/problem/36)


## Description

Find the middle node of a given linked list.

Examples



*   L = null, return null
*   L = 1 -> null, return 1
*   L = 1 -> 2 -> null, return 1
*   L = 1 -> 2 -> 3 -> null, return 2
*   L = 1 -> 2 -> 3 -> 4 -> null, return 2


## Assumption

The input head node (linked list) should not be null


## Algorithm

A classical fast/slow pointer example.



*   slow node is initialized to the head node
*   fast node is initialized to head.next
*   slow moves one step at a time
*   fast moves two steps at a time
*   when fast reaches the end of the list or just gets out, slow points to the middle node of the list


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
  public ListNode middleNode(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
```



### Complexity

Time: there are n nodes in the linked list and we need to traverse the whole list. The fast node moves two steps at a time ⇒ O(n/2) ⇒ O(n).

Space: two ListNode objects ⇒ O(1).


<!-- GD2md-html version 1.0β13 -->
