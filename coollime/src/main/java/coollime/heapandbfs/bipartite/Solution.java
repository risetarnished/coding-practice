package coollime.heapandbfs.bipartite;

import coollime.helper.GraphNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

  public boolean isBipartite(List<GraphNode> graph) {
    if (graph == null) {
      return false;
    } else if (graph.isEmpty()) {
      return true;
    }
    // Use a HashMap to record the <node, group number> grouping relationship
    Map<GraphNode, Integer> groups = new HashMap<>();
    // For each node in the graph, if any one of them violates the grouping rule
    // the whole graph is not bipartite
    for (GraphNode node : graph) {
      if (!isBipartiteGroup(node, groups)) {
        return false;
      }
    }
    return true;
  }

  private boolean isBipartiteGroup(
    GraphNode node,
    Map<GraphNode, Integer> groups
  ) {
    if (groups.containsKey(node)) {
      return true;
    }
    // group 0 is chosen as the default group
    groups.put(node, 0);
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    while (!queue.isEmpty()) {
      GraphNode current = queue.poll();
      int currentGroup = groups.get(current);
      // The neighbors should have a different group number as that of current node
      int neighborGroup = currentGroup == 0 ? 1 : 0;
      for (GraphNode neighbor : current.neighbors) {
        if (!groups.containsKey(neighbor)) {
          // Case 1: neighbor has not been seen before
          groups.put(neighbor, neighborGroup);
          queue.offer(neighbor);
        } else if (groups.get(neighbor) == currentGroup) {
          // Case 2: neighbor has been seen and has the same group number as current
          return false;
        } // Case 3: neighbor has been seen and has a different group number as current
        // node: continue
      }
    }
    return true;
  }
}
