package M.Probability.Medium.MedianTracker;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MedianTracker
 *
 * @author meng
 * @date 1/21/19
 */
public class MedianTracker {
    /**
     * Use two heaps:
     * a maxHeap that stores the smaller half of the input flow
     * a minHeap that stores the larger half
     */
    private Queue<Integer> smallHalf;
    private Queue<Integer> largeHalf;

    public MedianTracker() {
        smallHalf = new PriorityQueue<>(Collections.reverseOrder());
        largeHalf = new PriorityQueue<>();
    }

    /**
     *
     * @param value: the value read from input stream
     *
     */
    public void read(int value) {
        // Write your implementation here
        if (smallHalf.isEmpty() || value <= smallHalf.peek()) {
            smallHalf.offer(value);
        } else {
            largeHalf.offer(value);
        }
        // Maintain the heaps such that:
        // small.size() == large.size() || small.size() == large.size() + 1
        if (smallHalf.size() > largeHalf.size() + 1) {
            // Case 1: too many elements in the smaller half
            largeHalf.offer(smallHalf.poll());
        } else if (smallHalf.size() < largeHalf.size()) {
            // Case 2: too many elements in the larger half
            smallHalf.offer(largeHalf.poll());
        }
    }

    public Double median() {
        // Write your implementation here
        if (smallHalf == null || largeHalf == null) {
            return null;
        }
        int totalSize = smallHalf.size() + largeHalf.size();
        if (totalSize == 0) {
            return null;
        } else if (totalSize % 2 == 0) {
            // Case 1: if there are even number of numbers read
            return (double) ((smallHalf.peek() + largeHalf.peek()) / 2.0);
        } else {
            // Case 2: if there are odd number of numbers read
            return (double) smallHalf.peek();
        }
    }
}
