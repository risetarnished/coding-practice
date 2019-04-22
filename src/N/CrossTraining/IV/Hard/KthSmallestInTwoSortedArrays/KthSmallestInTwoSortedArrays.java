package N.CrossTraining.IV.Hard.KthSmallestInTwoSortedArrays;

public class KthSmallestInTwoSortedArrays {
  public int kth(int[] a, int[]b, int k) {
    // Write your solution here
    // Corner case based on the assumption
    if (a == null || b == null || k < 0) {
      return Integer.MIN_VALUE;
    }
    if (a.length == 0) {
      return b[k - 1];
    } else if (b.length == 0) {
      return a[k - 1];
    }
    int i = 0;
    int j = 0;
    // round represents how many rounds we have run: run (k - 1) rounds in total
    int round = 1;
    while (round < k && i < a.length && j < b.length) {
      if (a[i] <= b[j]) {
        i++;
      } else {
        j++;
      }
      round++;
    }
    // Post-processing
    // If either of the two arrays has no more elements to compare
    // simply return the element in the other array
    if (i >= a.length) {
      return b[k - round + j];
    } else if (j >= b.length) {
      return a[k - round + i];
    }
    return a[i] <= b[j] ? a[i] : b[j];
  }

  public int kthImproved(int[] a, int[] b, int k) {
    // Write your solution here
    // Corner case based on the assumption
    if (a == null || b == null || k < 0) {
      return Integer.MIN_VALUE;
    }
    if (a.length == 0) {
      return b[k - 1];
    } else if (b.length == 0) {
      return a[k - 1];
    }
    return kthSmallest(a, 0, b, 0, k);
  }

  private int kthSmallest(int[] a, int aStart, int[] b, int bStart, int k) {
    // Base case:
    // 1. When either of the two arrays has no more elements to examing
    // 2. When k has become 1, this is when the answer comes out
    if (aStart >= a.length) {
      // Return the (start + k - 1)-th element ==> understand k-th
      return b[k - 1 + bStart];
    } else if (bStart >= b.length) {
      return a[k - 1 + aStart];
    }
    if (k == 1) {
      return Math.min(a[aStart], b[bStart]);
    }
    // Compare the (k/2)th element in a's subarray and in b's subarray
    // to determine which (k/2) partition contains the smallest k elements
    // Therefore, we can discard the other partition since the result is impossible
    // to be included there
    int aMid = aStart + k / 2 - 1;
    int bMid = bStart + k / 2 - 1;
    int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
    int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
    if (aVal <= bVal) {
      return kthSmallest(a, aMid + 1, b, bStart, k - k / 2);
    } else {
      return kthSmallest(a, aStart, b, bMid + 1, k - k / 2);
    }
  }
}
