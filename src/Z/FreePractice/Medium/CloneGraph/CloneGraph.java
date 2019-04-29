package Z.FreePractice.Medium.CloneGraph;

import java.util.*;

public class CloneGraph {
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