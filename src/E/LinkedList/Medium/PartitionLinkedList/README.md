<!----- Conversion time: 0.601 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 20:00:27 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1qyCkg6YXgTdMvgCzp1F1mDlndkZcAXKi5Co0VsdSngk
----->



# Partition Linked List

[https://app.laicode.io/app/problem/42](https://app.laicode.io/app/problem/42)


## Description


    Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.


    Examples



*   L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null




Medium

Linked List

Partition


## Assumption

The input linked list should not be null or empty.


## Algorithm

This question is similar to [QuickSort](../../../../A/SortingAlgorithms/Medium/QuickSort).

We can do it in the following steps:



1.  Create/allocate two new linked lists (dummy head)
1.  Compare every node in the list with the target, put all the nodes that have values smaller than the target to newListOne. Otherwise, put them to newListTwo
    1.  If current.value < target: newListOne.append(current)
    1.  else: newListTwo.append(current)
1.  Concatenate newListOne and newListTwo and cut off at the end
    1.  listTwoTail.next = null;

Special attention should be paid to prevent a cycle from forming during the process




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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    // Traverse the list, put all the nodes that are less than the target
    // to a new list, all the nodes that are equal or larger than the
    // target to another.
    // Link the two lists together
    ListNode smallDummy = new ListNode(0);
    ListNode smallCurr = smallDummy;
    ListNode largeDummy = new ListNode(0);
    ListNode largeCurr = largeDummy;
    ListNode curr = head;
    while (curr != null) {
      if (curr.value < target) {
        smallCurr.next = curr;
        smallCurr = smallCurr.next;
      } else {
        largeCurr.next = curr;
        largeCurr = largeCurr.next;
      }
      curr = curr.next;
    }
    // Concatenate the two lists
    // smallHead → ... → smallCurr → largeHead → ... → largeCurr → null
    smallCurr.next = largeDummy.next;
    largeCurr.next = null;
    return smallDummy.next;
  }
}
```



### Complexity

Time: there are n nodes to compare ⇒ O(n).

Space: only dummy nodes are created, nothing lese ⇒ O(1).


<!-- GD2md-html version 1.0β13 -->
