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

**Assumptions**

- ListOfLists is not null, and none of the lists is null.

**Tags**

- Medium
- Heap


## Assumption

- Input is a list of linked lists
- Each one of these lists are sorted in ascending order
- The expected output is one big linked list sorted in ascending order


## Solution

Similar to the [Merge K Sorted Arrays](../MergeKSortedArrays) problem. We can use the "K way merge" method, which utilizes a minHeap of size k to get a current minimum each time. Everytime a node is polled out of the heap, we feed the heap with its next node if there is one.

### High-level Idea

- To output in one big sorted linked list, we can use a dummy head
  - Each time when we move the dummy head, we should point the current smallest node in all lists to dummy.next
- To easily get the smallest node in among the k lists
  - Use a min heap with a size of k
    - Initialize the heap with the head of the k lists
  - Link the min heap's top to dummy.next
  - Offer its next node in the original list to the heap
  - Continue until all nodes in the list of linked lists are checked. That is, until the heap becomes empty


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
    // Write your solution here
    // Corner cases check based on the assumption
    if (listOfLists == null || listOfLists.isEmpty()) {
      return null;
    }
    int k = listOfLists.size();
    // Use a min heap to generate the smallest node from the k lists
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
      	k, new Comparator<ListNode>() {
          @Override
          public int compare(ListNode a, ListNode b) {
            if (a.value == b.value) {
              return 0;
            }
            return a.value < b.value ? -1 : 1;
          }
        }
    );
    // Initialize the heap with the head nodes of the k linked lists
    for (ListNode head : listOfLists) {
      if (head == null) {
        continue;
      }
      minHeap.offer(head);
    }
    // Use a dummy node to store the result
    ListNode result = new ListNode(0);
    ListNode curr = result;
    // Link the smallest node of the k linked lists so far to the result
    // Offer the next node to the heap
    // Terminate when the heap becomes empty
    while (!minHeap.isEmpty()) {
      ListNode min = minHeap.poll();
      curr.next = min;
      if (min.next != null) {
        minHeap.offer(min.next);
      }
      curr = curr.next;
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

- Time
  - If there are n nodes in the k linked lists in listOfLists in total
  - There are k nodes in the min heap
    - Each offer and poll operation costs O(log(k))
  - Total time is O(n * k * log(k))
- Space
  - A PriorityQueue (minHeap) with a size of k
  - O(k)


<!-- Docs to Markdown version 1.0β14 -->
