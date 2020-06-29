package coollime.binarysearch.findminimuminrotatedsortedarray;

public class Solution {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    if (nums[start] < nums[end]) {
      return nums[start];
    }
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      } else if (nums[mid] < nums[mid - 1]) {
        return nums[mid];
      } else if (nums[mid] > nums[0]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return nums[start] < nums[end] ? nums[start] : nums[end];
  }
}
