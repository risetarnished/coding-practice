package H.DFS.II.Medium.AllSubsetsSizeOfK;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsSizeOfK {
  public List<String> subSets(String set, int k) {
    // Corner case
    List<String> result = new ArrayList<>();
    if (set == null || k < 0) {
      return result;
    }
    // Do a depth-first search to look for all possible subsets which has a size of k
//    findAllSubsets(set, k, new StringBuilder(), 0, result);
    findAllSubsetsAlt(set, k, new StringBuilder(), 0, result);
    return result;
  }

  private void findAllSubsets(String set, int k, StringBuilder subset, int index,
                              List<String> result) {
    // Base case: when all elements have been checked and the subset has a size of k
    if (index == set.length()) {
      if (subset.length() == k) {
        result.add(subset.toString());
      }
      return;
    }
    // Case 1: add the current element
    subset.append(set.charAt(index));
    findAllSubsets(set, k, subset, index + 1, result);
    subset.deleteCharAt(subset.length() - 1);
    // Case 2: skip the current element
    findAllSubsets(set, k, subset, index + 1, result);
  }

  private void findAllSubsetsAlt(String set, int k, StringBuilder subset, int index,
                              List<String> result) {
    // Base case: when the subset has a size of k
    if (subset.length() == k) {
      result.add(subset.toString());
      return;
    }
    // In each level, consider adding or skipping the current element and move on
    for (int i = index; i < set.length(); i++) {
      subset.append(set.charAt(i));
      findAllSubsetsAlt(set, k, subset, i + 1, result);
      subset.deleteCharAt(subset.length() - 1);
    }
  }
}
