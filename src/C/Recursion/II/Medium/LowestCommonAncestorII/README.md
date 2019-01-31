<!----- Conversion time: 2.143 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Wed Jan 23 2019 05:08:58 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1o7qem3uRyiY7M8y4j-2xN9V1mEnj1I7gWV4fAsxU6UE
* This document has images: check for >>>>>  gd2md-html alert:  inline image link in generated source and store images to your server.
----->


# Lowest Common Ancestor II

[https://app.laicode.io/app/problem/127](https://app.laicode.io/app/problem/127)


## Description

Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions



*   There is parent pointer for the nodes in the binary tree
*   The given two nodes are not guaranteed to be in the binary tree

Examples

            5

          /   \

         9     12

       /  \      \

      2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

Medium

Binary Tree

Linked List


## Assumption

The tree should not be null.

The two nodes are not guaranteed to be in the tree.

The parent pointer of the root node is null.


## Algorithm

[Lowest Common Ancestor I](../LowestCommonAncestorI)

Classic LCA:


![alt_text](lca0.png "image_tooltip")


This specific problem:


![alt_text](lca1.png "image_tooltip")



## Solution


### Code


```java
/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    if (one == null || two == null) {
      return null;
    }
    return lca(one, two, getDepth(one), getDepth(two));
  }

  private int getDepth(TreeNodeP node) {
    if (node == null) {
      return 0;
    }
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.parent;
    }
    return depth;
  }

  private TreeNodeP lca(TreeNodeP one, TreeNodeP two,
                        int depthOne, int depthTwo) {
    // Corner case: if either of them is null
    if (depthOne == 0 || depthTwo == 0) {
      return null;
    }
    // Traverse from the deeper node until reaching the other node's level
    // At that point, traverse along the two node's parent pointers
    // until reaching a common node
    int diff = depthOne - depthTwo;
    TreeNodeP curr = null;
    if (diff > 0) {
      // Case 1: one sits deeper
      curr = one;
      while (diff > 0) {
        diff--;
        curr = curr.parent;
      }
      // When the two nodes are in the same level
      // Only when we traverse upwards to a common node
      // will we find their lca
      while (curr != two) {
        curr = curr.parent;
        two = two.parent;
      }
    } else {
      // Case 2: two sits deeper
      curr = two;
      while (diff < 0) {
        diff++;
        curr = curr.parent;
      }
      while (curr != one) {
        curr = curr.parent;
        one = one.parent;
      }
    }
    return curr;
  }
}
```



### Complexity

Time:

For this particular question, not every node is checked. Traversal only happens on either node. In the worst case,



1.  the node may sit at the bottom of the tree as a leaf node.
1.  the LCA may be the root or there may not be any LCA at all because of the absence of either node.

⇒ O(height)

Space:

O(1)


<!-- Docs to Markdown version 1.0β14 -->
