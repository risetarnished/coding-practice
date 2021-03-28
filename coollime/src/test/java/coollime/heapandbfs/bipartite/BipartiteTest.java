package coollime.heapandbfs.bipartite;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.helper.GraphNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BipartiteTest {
  private static Solution sut;
  private List<GraphNode> graph;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    graph = null;
  }

  @Test
  void shouldReturnFalseWhenTheGraphIsInvalid() {
    assertFalse(sut.isBipartite(graph));
  }

  @Test
  void shouldReturnTrueWhenTheGraphIsEmpty() {
    graph = new ArrayList<>();
    assertTrue(sut.isBipartite(graph));
  }

  @Test
  void shouldReturnTrueWhenTheGraphIsBipartite() {
    // Example graph:
    // 1 -- 2
    //
    // /
    //
    // 3 -- 4
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
    graph = Arrays.asList(one, two, three, four);
    assertTrue(sut.isBipartite(graph));
  }

  @Test
  void shouldReturnFalseWhenTheGraphIsNotBipartite() {
    // Example graph:
    // 1 -- 2
    //
    // / |
    //
    // 3 -- 4
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
    graph = Arrays.asList(one, two, three, four);
    assertFalse(sut.isBipartite(graph));
  }
}
