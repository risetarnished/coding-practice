package N.CrossTraining.II.Medium.DeepCopyUndirectedGraph;

import helper.GraphNode.GraphNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeepCopyUndirectedGraphTest {
    private static DeepCopyUndirectedGraph deepCopyUndirectedGraph;
    private List<GraphNode> graph;

    @BeforeAll
    static void setInstance() {
        deepCopyUndirectedGraph = new DeepCopyUndirectedGraph();
    }

    @BeforeEach
    void setUp() {
        graph = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void copy() {
        assertEquals(new ArrayList<>(), deepCopyUndirectedGraph.copy(graph));

        graph = new ArrayList<>();
        assertEquals(new ArrayList<>(), deepCopyUndirectedGraph.copy(graph));

        graph = buildExampleGraph();
        List<GraphNode> expected = buildExampleGraph();
        assertEquals(expected, deepCopyUndirectedGraph.copy(graph));
    }

    private List<GraphNode> buildExampleGraph() {
        List<GraphNode> graph = new ArrayList<>();
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        one.neighbors = new ArrayList<>(Arrays.asList(two, three));
        two.neighbors = new ArrayList<>(Arrays.asList(one, three));
        three.neighbors = new ArrayList<>(Arrays.asList(one, two));
        return graph;
    }
}