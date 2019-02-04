package B.BinarySearch.Medium.FindMinimumInRotatedSortedArray;

/**
 * FindMinimumInRotatedSortedArray
 *
 * @author meng
 * @date 2/4/19
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // If the last element > the first element
        // The array is not rotated
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        // When the array has been rotated
        // Look for the rotation point/index
        // The element next to it is the smallest one
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[0]) {
                // Because the array is rotated
                // When the mid is greater than the start
                // It means the min is still to the right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
