package L.DynamicProgramming.I.Easy.LongestAscendingSubArray;

public class LongestAscendingSubArray {
    public int longest(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] subarrayLength = new int[array.length];
        subarrayLength[0] = 1;
        int longest = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                subarrayLength[i] = subarrayLength[i - 1] + 1;
                longest = Math.max(longest, subarrayLength[i]);
            } else {
                subarrayLength[i] = 1;
            }
        }
        return longest;
    }

    public int longestAlt(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = 1;
        int longest = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                length++;
                longest = Math.max(longest, length);
            } else {
                length = 1;
            }
        }
        return longest;
    }
}
