package coollime.recursion.binarytreepathsumtotargetiii;

import static org.junit.jupiter.api.Assertions.*;

import coollime.helper.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreePathSumToTargetIIITest {
  private static Solution sut;
  private TreeNode root;
  private int target;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @BeforeEach
  void setUp() {
    root = null;
    target = 0;
  }

  @Test
  void shouldNotFindAPathWhenThereAreNoPathsSumUpToTarget() {
    assertFalse(sut.exist(root, target));
  }

  @Test
  void shouldFindAPathWhenThereIsAPathSumsUpToTarget() {
    root =
      TreeNode.buildTree(
        new ArrayList<>(Arrays.asList(5, 2, 11, null, null, 6, 14, 3))
      );
    target = 17;
    assertTrue(sut.exist(root, target));
  }
}
