package L.DynamicProgramming.I.Medium.ArrayHopperI;

public class ArrayHopperI {
    public boolean canJump(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return false;
        }
        boolean canHop[] = new boolean[array.length];
        // Base case: when we are hopping at the end
        canHop[array.length - 1] = true;
        for (int i = array.length - 2; i >= 0; i--) {
            // If the max number of hops at the current
            // position makes it out of bounds
            // We are guaranteed to reach the end
            if (i + array[i] >= array.length - 1) {
                canHop[i] = true;
            } else {
                // For each array[i], the possible number of
                // hops are from 1 to array[i]
                for (int j = 1; j <= array[i]; j++) {
                    if (canHop[i + j]) {
                        canHop[i] = true;
                        break;
                    }
                }
            }
        }
        return canHop[0];
    }
}
