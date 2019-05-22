package G.HeapAndBFS.Medium.WallsAndGates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  private final int INF = Integer.MAX_VALUE;

  private Solution solution;
  private int[][] rooms;

  @BeforeEach
  void setUp() {
    solution = new Solution();
    rooms = null;
  }

  @Test
  void testNull_returnNull() {
    assertEquals(rooms, solution.wallsAndGates(rooms));
  }

  @Test
  void testEmpty_returnEmptyMatrix() {
    rooms = new int[][] {};
    assertEquals(rooms, solution.wallsAndGates(rooms));
  }

  @Test
  void testEmptyRow_returnEmpty2DMatrix() {
    rooms = new int[][] {{}};
    assertEquals(rooms, solution.wallsAndGates(rooms));
  }

  @Test
  void testExampleMatrix_returnExampleOutput() {
    rooms = new int[][] {
        {INF, -1, 0, INF},
        {INF, INF, INF, -1},
        {INF, -1, INF, -1},
        {0, -1, INF, INF}
    };
    int[][] expected = new int[][] {
        {3, -1, 0, 1},
        {2, 2, 1, -1},
        {1, -1, 2, -1},
        {0, -1, 3, 4}
    };
    assertEquals(expected, solution.wallsAndGates(rooms));
  }
}