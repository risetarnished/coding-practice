package coollime.binarytree.getkeysinbinarysearchtreeingivenrange;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.helper.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetKeysInBinarySearchTreeInGivenRangeTest {
  private static Solution sut;
  private TreeNode root;
  private int min;
  private int max;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
    min = Integer.MIN_VALUE;
    max = Integer.MAX_VALUE;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotReturnAnyKeysIfTheTreeIsInvalid() {
    List<Integer> result = sut.getRange(root, min, max);
    assertEquals(new ArrayList<>(), result);

    result = sut.getRangeRecursively(root, min, max);
    assertEquals(new ArrayList<>(), result);
  }

  @Test
  void shouldNotReturnAnyKeysIfThereAreNoKeysInRange() {
    // Nothing in range
    // Same tree above
    // range = [13, 15]
    root =
      TreeNode.buildTree(
        new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11))
      );
    min = 13;
    max = 15;
    List<Integer> result = sut.getRange(root, min, max);
    assertEquals(new ArrayList<>(), result);

    result = sut.getRangeRecursively(root, min, max);
    assertEquals(new ArrayList<>(), result);
  }

  @Test
  void shouldReturnTheKeysInRange() {
    root = new TreeNode(0);
    List<Integer> result = sut.getRange(root, min, max);
    List<Integer> expected = new ArrayList<>(Collections.singletonList(0));
    assertEquals(expected, result);

    // Example BST: in-order [5, 3, 8, 1, 4, null, 11]
    // 5
    //
    // / \
    //
    // 3 8
    //
    // / \ \
    //
    // 1 4 11
    root =
      TreeNode.buildTree(
        new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11))
      );
    min = 2;
    max = 5;
    result = sut.getRange(root, min, max);
    expected = new ArrayList<>(Arrays.asList(3, 4, 5));
    assertEquals(expected, result);

    result = sut.getRangeRecursively(root, min, max);
    assertEquals(expected, result);
  }
}
