<!----- Conversion time: 0.9 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Jan 28 2019 01:10:43 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1T5knTeYfuexfWZhCw624w8MEycYIoHhMUzM0sS0L1-g
----->



# Deep Copy Linked List with Random Pointer

[https://app.laicode.io/app/problem/131](https://app.laicode.io/app/problem/131)


## Description

Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.

Medium

Hashtable

Linked List


## Assumption

The linked list is not null and its hashCode() and equals() methods have been properly overridden.


## Algorithm

This is pretty much one of the graph traversal + neighbor visiting problem. So, BFS can be used to tackle this one. However, there is one important point in this problem. How do we establish the relationship between the _original nodes _and the _copied nodes_. Quick answer is a hash table with <original node, copied node>. And when we expand the original node, we need to check if its next and random nodes have been copied already (this is the point of this problem -- random pointer could cause some node be copied before it gets pointed to by its previous node)

E.g.

        1  →  2  →  3  →  4  →  null

        |      |     |      |

        3      4    null    3

Node 3 will gets copied before node 2 is copied. So will node 4.


## Solution


### Code


```java
/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Write your solution here.
    if (head == null) {
      return null;
    }
    // Use a HashMap to keep track of the node that has been copied
    // with a relationship <original node, copied node>
    Map<RandomListNode, RandomListNode> generated = new HashMap<>();
    RandomListNode copyHead = new RandomListNode(head.value);
    generated.put(head, copyHead);
    RandomListNode copyNode = copyHead;
    while (head != null) {
      // Case 1: copy the next pointer
      if (head.next != null) {
        // Insert the current node being copy to the map if absent
        if (!generated.containsKey(head.next)) {
          generated.put(head.next, new RandomListNode(head.next.value));
        }
        // Connect the copied node's next pointer to its next node
        copyNode.next = generated.get(head.next);
      }
      // Case 2: copy the random pointer
      if (head.random != null) {
        if (!generated.containsKey(head.random)) {
          generated.put(head.random,
                        new RandomListNode(head.random.value));
        }
        copyNode.random = generated.get(head.random);
      }
      head = head.next;
      copyNode = copyNode.next;
    }
    return copyHead;
  }
}
```



### Complexity


#### Time

Although we are generating and expanding each node's next and random nodes, we are only visiting each node once because of the hash table. ⇒ O(n)


#### Space

We used a hash table to keep track of the original node and its generated node ⇒ O(n)


<!-- Docs to Markdown version 1.0β14 -->
