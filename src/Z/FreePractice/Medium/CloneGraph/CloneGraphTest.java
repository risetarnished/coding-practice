package Z.FreePractice.Medium.CloneGraph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {
  private static CloneGraph instance;
  private Node node;

  @BeforeAll
  static void setInstance() {
    instance = new CloneGraph();
  }

  @BeforeEach
  void setUp() {
    node = null;
  }

  @Test
  void cloneGraph() {
    node = new Node(1, new ArrayList<>());
    Node two = new Node(2, new ArrayList<>());
    Node three = new Node(3, new ArrayList<>());
    Node four = new Node(4, new ArrayList<>());
    node.neighbors.add(two);
    two.neighbors.add(three);
    three.neighbors.add(four);
    four.neighbors.add(node);

    Node copied = instance.cloneGraph(node);
    assertNotNull(copied);
  }
}