package L.DynamicProgramming.II.Medium.ArrayHopperII;

public class ArrayHopperII {
    public int minJump(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        int n = array.length;
        int[] jumps = new int[n];
        // jumps[i] represents the min # of jumps it takes
        // from here to get to the end
        // Base case: 0 jumps when we are at the end
        jumps[n - 1] = 0;
        // Iterate in the direction from end to start
        for (int i = n - 2; i >= 0; i--) {
            // If the max # of jumps at the position is 0
            // We can jump to nowhere
            if (array[i] == 0) {
                jumps[i] = -1;
                continue;
            }
            int minJumps = Integer.MAX_VALUE;
            // We need to check every possible jump to
            // find the min # of jumps
            for (int j = 1; j <= array[i]; j++) {
                if (i + j > n - 1) {
                    // When we jump out of bounds
                    // We have already found a result
                    break;
                }
                if (jumps[i + j] == -1) {
                    // Skip the ones that cannot make it
                    continue;
                }
                minJumps = Math.min(minJumps, jumps[i + j]);
            }
            jumps[i] = minJumps == Integer.MAX_VALUE ? -1 : minJumps + 1;
        }
        return jumps[0];
    }
}
