package coollime.binarytree.general.tweaked;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.helper.TreeNode;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TweakedIdenticalBinaryTreesTest {

  private static Solution sut;
  private TreeNode one;
  private TreeNode two;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    one = null;
    two = null;
  }

  @Test
  void shouldReturnTrueWhenTheTreesAreEmpty() {
    assertTrue(sut.isTweakedIdentical(one, two));
  }

  @Test
  void shouldReturnFalseWhenTreesAreDifferent() {
    // Tree one:
    // 5
    //
    // / \
    //
    // 3 8
    //
    // / \
    //
    // 1 4
    // Tree two:
    // 5
    //
    // / \
    //
    // 8 3
    //
    // \ /
    //
    // 4 1
    one = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4));
    two = TreeNode.buildTree(Arrays.asList(5, 8, 3, null, 4, 1));
    assertFalse(sut.isTweakedIdentical(one, two));
  }

  @Test
  void shouldReturnTrueWhenTheTreesAreIdentical() {
    one = new TreeNode(0);
    two = new TreeNode(0);
    assertTrue(sut.isTweakedIdentical(one, two));

    // Tree one:
    // 5
    //
    // / \
    //
    // 3 8
    //
    // / \
    //
    // 1 4
    // Tree two:
    // 5
    //
    // / \
    //
    // 8 3
    //
    // / \
    //
    // 1 4
    one = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4));
    two = TreeNode.buildTree(Arrays.asList(5, 8, 3, null, null, 1, 4));
    assertTrue(sut.isTweakedIdentical(one, two));
  }
}
