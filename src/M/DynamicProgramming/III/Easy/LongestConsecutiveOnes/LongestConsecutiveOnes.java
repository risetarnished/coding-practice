package M.DynamicProgramming.III.Easy.LongestConsecutiveOnes;

public class LongestConsecutiveOnes {
    public int longest(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 0;
        }
        int ones = array[0];
        int maxOnes = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                maxOnes = Math.max(maxOnes, ++ones);
            } else {
                ones = 0;
            }
        }
        return maxOnes;
    }
}
