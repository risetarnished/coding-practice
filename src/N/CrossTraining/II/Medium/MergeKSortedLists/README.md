<!----- Conversion time: 0.906 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Jan 28 2019 17:04:20 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=12zrUNxJTIfUCAn_FuVDN1lR0eD4VjScKFe8jf4y6zcg
----->



# Merge K Sorted Lists

[https://app.laicode.io/app/problem/134](https://app.laicode.io/app/problem/134)


## Description

Merge K sorted lists into one big sorted list in ascending order.

Assumptions



*   ListOfLists is not null, and none of the lists is null.

Medium

Heap




## Assumption

The input listOfLists should not be null or empty. At least one of the list of the lists should have something in it.


## Algorithm

Similar to the [Merge K Sorted Arrays](../MergeKSortedArrays) problem. We can use the "K way merge" method, which utilizes a minHeap of size k to get a current minimum each time. Everytime a node is polled out of the heap, we feed the heap with its next node if there is one.




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
  public ListNode merge(List<ListNode> listOfLists) {
    // Write your solution here/.
    if (listOfLists == null || listOfLists.isEmpty()) {
      return null;
    }
    // Use a min heap
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
        listOfLists.size(),
        new Comparator<ListNode>() {
          @Override
          public int compare(ListNode one, ListNode two) {
            if (one.value == two.value) {
              return 0;
            }
            return one.value < two.value ? -1 : 1;
          }
        }
    );
    // Initiate with the head node of each linked list
    for (ListNode head : listOfLists) {
      // Skip any empty lists
      if (head == null) {
        continue;
      }
      minHeap.offer(head);
    }
    // Use a dummy node to keep track of the result list
    ListNode result = new ListNode(0);
    ListNode current = result;
    // Get the min node from the heap and
    // fill the spot with its next node each time
    while (!minHeap.isEmpty()) {
      ListNode min = minHeap.poll();
      current.next = min;
      // Fill the empty spot
      if (min.next != null) {
        minHeap.offer(min.next);
      }
      current = current.next;
    }
    return result.next;
  }
}
```


_Of course, the comparator can be implemented using lambda (laicode does not support this yet):_


```java
PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
    listOfLists.size(),
    (one, two) -> {
      if (one.value == two.value) {
        return 0;
      }
      return one.value < two.value ? -1 : 1;
    }
);
```



### Complexity


#### Time

There are n nodes in each one of the k linked lists ⇒ O(n * k)

For every node, we need to offer()/poll() it to/from the heap ⇒ O(log(k))

In total ⇒ O(n*k * log(k))


#### Space

A min heap with a size of k is used ⇒ O(k)


<!-- Docs to Markdown version 1.0β14 -->
