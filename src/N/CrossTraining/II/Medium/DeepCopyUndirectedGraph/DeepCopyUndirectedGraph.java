package N.CrossTraining.II.Medium.DeepCopyUndirectedGraph;

import helper.GraphNode.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DeepCopyUndirectedGraph
 *
 * @author meng
 * @date 1/28/19
 */
public class DeepCopyUndirectedGraph {
    /**
     * Make a deep copy of an undirected graph
     * There could be cycles in the graph
     *
     * @param graph    A list of GraphNode objects that represents an undirected graph
     * @return         A deep copy of the given undirected graph
     */
    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here
        List<GraphNode> result = new ArrayList<>();
        if (graph == null || graph.isEmpty()) {
            return result;
        }
        // Use a HashMap to record the relationship
        // <original node, generated node>
        Map<GraphNode, GraphNode> generated = new HashMap<>(graph.size());
        // For each node in the graph, we generate a copy of it if it has not done so
        for (GraphNode node : graph) {
            if (!generated.containsKey(node)) {
                generated.put(node, new GraphNode(node.key));
            }
            GraphNode copy = generated.get(node);
            // For each node, copy all its neighbors
            for (GraphNode neighbor : node.neighbors) {
                if (!generated.containsKey(neighbor)) {
                    generated.put(neighbor, new GraphNode(neighbor.key));
                }
                copy.neighbors.add(generated.get(neighbor));
            }
            // Add the fully copied node to the result
            result.add(copy);
        }
        return result;
    }
}
