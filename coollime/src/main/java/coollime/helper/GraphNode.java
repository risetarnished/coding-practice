package coollime.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {
  public int key;
  public List<GraphNode> neighbors;

  public GraphNode(int key) {
    this.key = key;
    neighbors = new ArrayList<>();
  }

  /**
   * Build an undirected graph given a list of keys and adjacency list of each node
   *
   * Structure of adjacency list:
   * [ [neighbors of node 0], [neighbors of node 1], [neighbors of node 2], ... , ]
   *
   * The keys list should have the same length as that of adjacency list
   *
   * @param nodeKeys      Keys of corresponding nodes
   * @param adjacencyList Adjacency list of each node
   * @return              An undirected graph of the nodes
   */
  public static List<GraphNode> buildGraph(
    List<Integer> nodeKeys,
    List<List<GraphNode>> adjacencyList
  ) {
    // TODO(MZ): This is not correct - Need to figure out another way (probably need a map or set)
    List<GraphNode> graph = new ArrayList<>();
    if (nodeKeys == null || nodeKeys.isEmpty()) {
      // return graph;
      throw new IllegalArgumentException("Invalid keys of node");
    }
    // Build the GraphNode list first
    for (Integer key : nodeKeys) {
      graph.add(new GraphNode(key));
    }
    // Complete the neighbors list
    for (int i = 0; i < adjacencyList.size(); i++) {
      graph.get(i).neighbors = new ArrayList<>(adjacencyList.get(i));
    }
    return graph;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GraphNode)) {
      return false;
    }
    GraphNode graphNode = (GraphNode) o;
    return (
      key == graphNode.key && Objects.equals(neighbors, graphNode.neighbors)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, neighbors);
  }
}
