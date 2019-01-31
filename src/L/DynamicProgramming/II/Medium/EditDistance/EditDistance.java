package L.DynamicProgramming.II.Medium.EditDistance;

public class EditDistance {
    public int editDistance(String one, String two) {
        // Write your solution here
        if (one == null || two == null) {
            return -1;
        }
        int m = one.length();
        int n = two.length();
        int[][] distance = new int[m + 1][n + 1];
        // distance[i][j] represents the min # of operations
        // needed to transform the first i letters of one
        // into the first j letters of two
        // Initialize the top row and left column
        for (int i = 0; i <= n; i++) {
            distance[0][i] = i;
        }
        for (int j = 0; j <= m; j++) {
            distance[j][0] = j;
        }
        // For each letter in string one, check the # of operations
        // it takes to transform it into string two
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    // Case 1:
                    // the first i letters of one is the same as
                    // the first j letters of two ==> no changes needed
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    // Case 2:
                    // check the # of operations of
                    // replacement, insertion, and deletion
                    // Take the min among them
                    distance[i][j] = Math.min(distance[i - 1][j - 1],
                                              Math.min(distance[i - 1][j],
                                                       distance[i][j - 1])) + 1;
                }
            }
        }
        return distance[m][n];
    }
}
