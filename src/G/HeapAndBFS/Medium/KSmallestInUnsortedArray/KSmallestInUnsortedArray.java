package G.HeapAndBFS.Medium.KSmallestInUnsortedArray;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://app.laicode.io/app/problem/25
 *
 * Description
 * Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
 *
 * Assumptions
 *
 * A is not null
 * K is >= 0 and smaller than or equal to size of A
 * Return
 *
 * an array with size K containing the K smallest numbers in ascending order
 * Examples
 *
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[] {};
        }
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        // Alternative way to create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                if (one.equals(two)) {
                    return 0;
                }
                return one > two ? -1 : 1;
            }
        });
        for (int element : array) {
            if (maxHeap.size() < k) {
                // Heapify the first k elements
                maxHeap.offer(element);
            } else if (maxHeap.peek() > element) {
                maxHeap.poll();
                maxHeap.offer(element);
            }
        }
        int[] result = new int[k];
        // Ascending order
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
