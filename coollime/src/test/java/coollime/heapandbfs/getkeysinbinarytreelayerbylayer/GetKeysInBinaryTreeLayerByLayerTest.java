package coollime.heapandbfs.getkeysinbinarytreelayerbylayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.helper.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetKeysInBinaryTreeLayerByLayerTest {
  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldNotTraverseWhenTheTreeIsInvalid() {
    assertEquals(new ArrayList<>(), sut.layerBylayer(root));
  }

  @Test
  void shouldTraverseWhenThereIsOneNode() {
    root = new TreeNode(0);
    List<List<Integer>> result = sut.layerBylayer(root);
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(0));
    assertEquals(expected, result);
  }

  @Test
  void shouldTraverseTheTreeByLevelOrder() {
    // In-order: [5, 3, 8, 1, 4, null, 11]
    // 5
    //
    // / \
    //
    // 3 8
    //
    // / \ \
    //
    // 1 4 11
    root = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4, null, 11));
    List<List<Integer>> result = sut.layerBylayer(root);
    List<List<Integer>> expected = Arrays.asList(
      Collections.singletonList(5),
      Arrays.asList(3, 8),
      Arrays.asList(1, 4, 11)
    );
    assertEquals(expected, result);
  }
}
