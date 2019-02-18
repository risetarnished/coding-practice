package B.BinarySearch.Medium.SearchInUnknownSizedSortedArray;

/**
 * https://app.laicode.io/app/problem/20
 * Description
 * Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order,
 * determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.
 *
 * Assumptions
 *
 * dictionary A is not null
 * dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds
 * Examples
 *
 * A = {1, 2, 5, 9, ......}, T = 5, return 2
 * A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 **/

/*
 *  interface Dictionary {
 *      public Integer get(int index);
 *  }
 */

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class SearchInUnknownSizedSortedArray {
    public int search(Dictionary dict, int target) {
        // Write your solution here
        if (dict == null || dict.get(0) == null) {
            return -1;
        }
        // Look for the searching range of interest
        int start = 0;
        int end = 1;
        while (end < Integer.MAX_VALUE / 2 && dict.get(end) != null && dict.get(end) < target) {
            // Narrow down the range to [current_end, 2 * current_end]
            start = end + 1;
            end *= 2;
        }
        // Classical BS from this point on
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // mid could be out of bound
            if (dict.get(mid) == null) {
                end = mid - 1;
                continue;
            }
            if (dict.get(mid) == target) {
                return mid;
            } else if (dict.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

/**
 * Time complexity: two binary search processes --> O(2 * log(n)) --> O(log(n))
 *
 * Space complexity: constant space --> O(1)
 **/
