package G.HeapAndBFS.Hard.Bipartite;

import helper.GraphNode.GraphNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BipartiteTest {
    private static Bipartite bipartite;
    private GraphNode node;
    private List<GraphNode> graph;

    @BeforeAll
    static void setInstance() {
        bipartite = new Bipartite();
    }

    @BeforeEach
    void setUp() {
        node = null;
        graph = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertFalse(bipartite.isBipartite(graph));
    }

    @Test
    void testEmpty() {
        graph = new ArrayList<>();
        assertTrue(bipartite.isBipartite(graph));
    }

    @Test
    void testValid() {
        // Example graph:
        //     1  --   2
        //
        //        /
        //
        //     3  --   4
        // is bipartite (1, 3 in group 1 and 2, 4 in group 2).
        // Build graph
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        one.neighbors.add(two);
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(three);
        // Test
        graph = new ArrayList<>(Arrays.asList(one, two, three, four));
        assertTrue(bipartite.isBipartite(graph));
    }

    @Test
    void testInvalid() {
        // Example graph:
        //     1  --   2
        //
        //        /   |
        //
        //     3  --   4
        // is not bipartite.
        // Build graph
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        one.neighbors.add(two);
        two.neighbors.add(one);
        two.neighbors.add(three);
        two.neighbors.add(four);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(two);
        four.neighbors.add(three);
        // Test
        graph = new ArrayList<>(Arrays.asList(one, two, three, four));
        assertFalse(bipartite.isBipartite(graph));
    }
}
