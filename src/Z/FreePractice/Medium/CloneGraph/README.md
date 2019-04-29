# Deep Copy Undirected Graph

[https://leetcode.com/problems/clone-graph/](https://leetcode.com/problems/clone-graph/)

## Description

Given a reference of a node in a **connected** undirected graph, return a [**deep copy**](https://en.wikipedia.org/wiki/Object_copying#Deep_copy) (clone) of the graph. Each node in the graph contains a val (`int`) and a list (`List[Node]`) of its neighbors.

 

**Example:**

![img](https://assets.leetcode.com/uploads/2019/02/19/113_sample.png)

```
Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
```

 

**Note:**

1. The number of nodes will be between 1 and 100.
2. The undirected graph is a [simple graph](https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)#Simple_graph), which means no repeated edges and no self-loops in the graph.
3. Since the graph is undirected, if node *p* has node *q* as neighbor, then node *q* must have node *p* as neighbor too.
4. You must return the **copy of the given node** as a reference to the cloned graph.

- Accepted
  - 211,208
- Submissions
  - 809,003

## Assumption

- The graph is not null
- The graph may have cycles

## Solution

### High-level Idea

- Do a breadth-first search on each original node to copy every single one of them
- Each time when we are copying a node, generate all its neighbors and copy them as well
- Use a HashMap to store the <original node, generated node for copy> relationship
  - Every time when a node is being copy, check if it has already been generated before
    - If it has, use the generated copy of it
    - If not, generate a copy of this node and use it to copy
  - Do the same for the node's neighbors
    - If the neighbor has not been generated before
      - Generate a new copy of it
      - Offer the neighbor to the queue
        - The queue should only contain the nodes that have not been copied

### Code

```java
/*
// Definition for a Node.
class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {}

  public Node(int _val,List<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
};
*/
class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }
    // The map "generated" keeps track of the 
    // <original node, generated copy> relationship
    Map<Node, Node> generated = new HashMap<>();
    // Start from the first node, use a FIFO queue,
    // expand the current node's neighbors. Copy all neighbors
    // and offer them to the queue
    // Terminate when the queue becomes empty
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(node);
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      // Get the generated copy of this node
      if (!generated.containsKey(current)) {
        generated.put(current, new Node(current.val, new ArrayList<>()));
      }
      Node copyNode = generated.get(current);
      // Expand and generate all its neighbors
      for (Node neighbor : current.neighbors) {
        // Skip the node if it has been generated
        if (!generated.containsKey(neighbor)) {
          generated.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
          queue.offer(neighbor);
        }
        Node copyNeighbor = generated.get(neighbor);
        copyNode.neighbors.add(copyNeighbor);
        // queue.offer(neighbor);
      }
    }
    return generated.get(node);
  }
}
```

### Complexity

- Time
  - The nodes will be generated for copy exactly once
  - Total time is O(n)
- Space
  - The HashMap takes O(n) space
  - Total space is O(n)

