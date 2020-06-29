package coollime.recursion.lowestcommonancestorii;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorIITest {
  private static Solution sut;
  private TreeNodeP root, one, two;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @BeforeEach
  void setUp() {
    buildTree();
    one = null;
    two = null;
  }

  @AfterEach
  void tearDown() {
    root = null;
    one = null;
    two = null;
  }

  @Test
  void shouldFindTheLCA() {
    one = getNode(2);
    two = getNode(14);
    assertEquals(root, sut.lowestCommonAncestor(one, two));

    two = getNode(9);
    assertEquals(two, sut.lowestCommonAncestor(one, two));

    two = getNode(3);
    assertEquals(getNode(9), sut.lowestCommonAncestor(one, two));

    two = new TreeNodeP(8, null);
    assertNull(sut.lowestCommonAncestor(one, two));
  }

  /**
   * Build a tree just for this problem
   * Not going to create a TreeNodeP class like TreeNode
   */
  private void buildTree() {
    TreeNodeP five = new TreeNodeP(5, null);
    TreeNodeP nine = new TreeNodeP(9, five);
    TreeNodeP twelve = new TreeNodeP(12, five);
    TreeNodeP two = new TreeNodeP(2, nine);
    TreeNodeP three = new TreeNodeP(3, nine);
    TreeNodeP fourteen = new TreeNodeP(14, twelve);
    five.left = nine;
    five.right = twelve;
    nine.left = two;
    nine.right = three;
    twelve.right = fourteen;
    this.root = five;
  }

  /**
   * Get the node with a given key value from the tree
   */
  private TreeNodeP getNode(int key) {
    Deque<TreeNodeP> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNodeP curr = stack.pollFirst();
      if (curr.key == key) {
        return curr;
      }
      if (curr.right != null) {
        stack.offerFirst(curr.right);
      }
      if (curr.left != null) {
        stack.offerFirst(curr.left);
      }
    }
    return null;
  }
}
