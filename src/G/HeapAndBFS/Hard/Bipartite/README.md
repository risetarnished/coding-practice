<!----- Conversion time: 0.782 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sun Jan 06 2019 04:33:13 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1mQCg5qtlCYm1gR1gB1GPvbVWwLm8kvpH3i0fMlWhWFo
----->



# Bipartite

[https://app.laicode.io/app/problem/56](https://app.laicode.io/app/problem/56)


## Description

Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.

Examples

    1  --   2

        /

    3  --   4

is bipartite (1, 3 in group 1 and 2, 4 in group 2).

    1  --   2

	    /   |

    3  --   4

is not bipartite.

Assumptions



*   The graph is represented by a list of nodes, and the list of nodes is not null.





Hard

Breadth First Search

Depth First Search




## Assumption

The graph should not be empty and it should be undirected.


## Algorithm

Start from the first node, do BFS. Any node that has not been assigned a group number can be assigned into either group. Then, generate all its neighbors and see which group they belong to.



1.  If any of the neighbors does not have a group number yet, assign the other group number to it.
1.  If the neighbor has the same group number as the node, return false.
1.  If the neighbor has a different group number as the node, continue




## Solution


### Code


```java
/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */

public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // Write your solution here
    // Corner case according to our assumption
    if (graph == null) {
      return false;
    } else if (graph.size() == 0) {
      return true;
    }
    // Use a HashMap to record the <node → group number> relationship
    Map<GraphNode, Integer> groups = new HashMap<>();
    // For each node in the graph, if any one of them violates the rule,
    // the whole graph is not bipartite
    for (GraphNode node : graph) {
      if (!isValidBipartite(node, groups)) {
        return false;
      }
    }
    return true;
  }

  private boolean isValidBipartite(GraphNode node,
                                   HashMap<GraphNode, Integer> groups) {
    // Starting from the first node in the graph, all of its neighbors
    // will be labeled with their corresponding group numbers.
    // Do the same for the rest of the nodes.
    // Only nodes with a group number which does not violate the rule
    // would be put into the map with a valid group number assigned.
    // Therefore, if a node is present in the map already, return true
    if (groups.containsKey(node)) {
      return true;
    }
    // If this node has not been seen before, it can be labeled with
    // either group 0 or 1
    // In this case, group 0 is chosen as the default group
    groups.put(node, 0);
    // Use a FIFO queue to do BFS
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    while (!queue.isEmpty()) {
      GraphNode current = queue.poll();
      int currentGroup = groups.get(current);
      // The neighbors should have a different group number
      int neighborGroup = currentGroup == 0 ? 1 : 0;
      // Expand and generate all the neighbors of the current node
      for (GraphNode neighbor : current.neighbors) {
        if (!groups.containsKey(neighbor)) {
          // Case 1: neighbor has not been seen before
          groups.put(neighbor, neighborGroup);
          queue.offer(neighbor);
        } else if (groups.get(neighbor) == currentGroup) {
          // Case 2: neighbor has the same group number
          return false;
        } // Case 3: neighbor has a different group number
      }
    }
    return true;
  }
}
```





### Complexity

Time: BFS time ⇒ for each node, we need to check all of its neighbors ⇒ O(n^2)

Space: a HashMap (O(n)), n nodes in the graph ⇒ n calls on the call-stack, each node's BFS process has a FIFO queue ⇒ O(n). Therefore, the total space complexity is O(n) + O(n^2) ⇒ O(n^2)


<!-- GD2md-html version 1.0β13 -->
