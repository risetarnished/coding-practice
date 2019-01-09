package I.HashTable.Easy.CommonNumbersOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://app.laicode.io/app/problem/72
 *
 * Description
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
 *
 * Assumptions
 *
 * In each of the two sorted arrays, there could be duplicate numbers.
 * Both two arrays are not null.
 * Examples
 *
 * A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */

public class CommonNumbersOfTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
            return result;
        }
        // Use a map to store <element, # of times it occurs in A> relationship
        Map<Integer, Integer> existsInA = new HashMap<>();
        for (Integer element : A) {
            existsInA.put(element, existsInA.getOrDefault(element, 0) + 1);
        }
        // For every element in B, look for its occurrence in A
        for (Integer number : B) {
            // If this number is present in A
            // and does not exceeds the number of occurrence in A
            // add it to the result
            if (existsInA.containsKey(number) && existsInA.get(number) > 0) {
                result.add(number);
                // Since we are moving forward, the searching window will
                // be moving towards right, as well.
                // The # of times this element appears in A needs to be
                // decremented by 1
                existsInA.put(number, existsInA.get(number) - 1);
            }
        }
        return result;
    }

    public List<Integer> commonAlt(List<Integer> A, List<Integer> B) {
        // Merge sort method
        List<Integer> result = new ArrayList<>();
        if (A == null || A.size() == 0 || B == null || B.size() == 0) {
            return result;
        }
        int left = 0;
        int right = 0;
        while (left < A.size() && right < B.size()) {
            if (A.get(left).equals(B.get(right))) {
                result.add(A.get(left));
                left++;
                right++;
            } else if (A.get(left) < B.get(right)) {
                left++;
            } else {
                right++;
            }
        }
        return result;
    }
}
