package N.CrossTraining.VI.Medium.LongestCommonSubstring;

public class LongestCommonSubstring {
  public String longestCommon(String source, String target) {
    // Write your solution here
    if (source == null || target == null) {
      return null;
    }
    // Keep track of the length and  the starting index of the longest common substring
    int longest = 0;
    int start = 0;
    // common[i][j] represents the length of the longest common substring of
    // the first i characters in source and the first j characters in target
    int[][] common = new int[source.length()][target.length()];
    for (int i = 0; i < source.length(); i++) {
      for (int j = 0; j < target.length(); j++) {
        if (source.charAt(i) == target.charAt(j)) {
          if (i == 0 || j == 0) {
            common[i][j] = 1;
          } else {
            common[i][j] = common[i - 1][j - 1] + 1;
          }
          // Update global max and the starting index
          if (common[i][j] > longest) {
            longest = common[i][j];
            // i is pointing to the end so far and the length is "longest"
            start = i - longest + 1;
          }
        }
      }
    }
    // source[start, start + longest] is the result
    return source.substring(start, start + longest);
  }
}
