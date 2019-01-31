<!----- Conversion time: 0.734 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Jan 28 2019 02:23:19 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1_e2hRaG3ZTqoLvbkV0r14PoiP1eNVoB2yWXYdzqgb1w
----->



# Deep Copy Undirected Graph

[https://app.laicode.io/app/problem/132](https://app.laicode.io/app/problem/132)


## Description

Make a deep copy of an undirected graph, there could be cycles in the original graph.

Medium

Breadth First Search

Depth First Search


## Assumption

The given graph is not null


## Algorithm

Graph node visiting problem ⇒ BFS can solve this one.

However, since there could be cycles in the graph, we need to figure out a way to know the relationship between the original graph nodes and the nodes generated in the copying process. For example,

    N1 --- N2

       \       /

          N3

So, we need a hash table to keep track of the nodes that have been generated already. If a node has been generated before, we will not need to create a new node when trying to copy its previous node. For example, when we are copying N2, we do not have to create a new N3' because it has already been generated when we are copying N1.


## Solution


### Code


```java
/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    List<GraphNode> result = new ArrayList<>();
    if (graph == null || graph.isEmpty()) {
      return result;
    }
    // Use a hash table to record the relationship between
    // <original node, generated node>
    // size(hash table) == size(graph)
    Map<GraphNode, GraphNode> generated = new HashMap<>(graph.size());
    // Use BFS to copy each node in the original graph
    for (GraphNode node : graph) {
      // Establish the 1-to-1 relationship if there has not been one
      if (!generated.containsKey(node)) {
        generated.put(node, new GraphNode(node.key));
      }
      // Copy this node
      GraphNode copy = generated.get(node);
      // For the target node, copy all of its neighbors
      for (GraphNode neighbor : node.neighbors) {
        if (!generated.containsKey(neighbor)) {
          generated.put(neighbor, new GraphNode(neighbor.key));
        }
        // Add the neighbor to the neighbor list
        copy.neighbors.add(generated.get(neighbor));
      }
      // Add the fully generated copy node to the result
      result.add(copy);
    }
    return result;
  }
}
```



### Complexity


#### Time

BFS ⇒ For each node, we need to copy all of its neighbors in the adjacency list ⇒ O(n^2)


#### Space

A hash table is used to establish the 1-to-1 relationship between the original nodes and the generated nodes ⇒ O(n).


<!-- Docs to Markdown version 1.0β14 -->
