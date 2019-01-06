package G.HeapAndBFS.Hard.Bipartite;

import helper.GraphNode.GraphNode;

import java.util.*;

/**
 * https://app.laicode.io/app/problem/56
 *
 * Description
 * Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.
 *
 * Examples
 *
 * 1  --   2
 *
 *     /
 *
 * 3  --   4
 *
 * is bipartite (1, 3 in group 1 and 2, 4 in group 2).
 *
 * 1  --   2
 *
 *     /   |
 *
 * 3  --   4
 *
 * is not bipartite.
 *
 * Assumptions
 *
 * The graph is represented by a list of nodes, and the list of nodes is not null.
 */

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // Write your solution here
        if (graph == null) {
            return false;
        } else if (graph.size() == 0) {
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

    private boolean isBipartiteGroup(GraphNode node, Map<GraphNode, Integer> groups) {
        // Starting from the first node in the graph, all of its neighbors will be labeled with their
        // corresponding group numbers. Do the same for the rest of the nodes.
        // Only nodes with a group number which does not violate the rule would be put into the map.
        // Therefore, if a node is present in the map already, return true directly
        if (groups.containsKey(node)) {
            return true;
        }
        // If this node has not been seen before, it can be labeled with either group 0 or 1
        // In this case, group 0 is chosen as the default group
        groups.put(node, 0);
        // Do BFS with the help of a FIFO queue
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            int currentGroup = groups.get(current);
            // The neighbors should have a different group number as that of current node
            int neighborGroup = currentGroup == 0 ? 1 : 0;
            // Expand the node and generate all its neighbors
            for (GraphNode neighbor : current.neighbors) {
                if (!groups.containsKey(neighbor)) {
                    // Case 1: neighbor has not been seen before
                    groups.put(neighbor, neighborGroup);
                    queue.offer(neighbor);
                } else if (groups.get(neighbor) == currentGroup) {
                    // Case 2: neighbor has been seen and has the same group number as current
                    return false;
                }   // Case 3: neighbor has been seen and has a different group number as current node: continue
            }
        }
        return true;
    }
}
