package N.CrossTraining.II.Medium.MergeKSortedArrays;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MergeKSortedArrays
 *
 * @author meng
 * @date 1/28/19
 */
public class MergeKSortedArrays {
    /**
     * Merge K sorted arrays into one big sorted array in ascending order
     *
     * @param arrayOfArrays    an array of K sorted arrays (in ascending order)
     * @return                 a big sorted array in ascending order
     */
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return new int[] {};
        }
        // Use a min heap of size K to get the smallest number from
        // K sorted arrays each time
        int k = arrayOfArrays.length;
        Queue<Element> minHeap = new PriorityQueue<>(k);
        // The length of each array may not be the same
        int totalLength = 0;
        for (int i = 0; i < k; i++) {
            // Check each one of the k arrays
            int[] currentArray = arrayOfArrays[i];
            // Skip any empty array
            if (currentArray.length == 0) {
                continue;
            }
            // If the current array does have elements in it
            // Update the total length and offer its first
            // element to the heap
            totalLength += currentArray.length;
            minHeap.offer(new Element(i, 0, currentArray[0]));
        }
        // Now the heap has the first element of each one of the
        // k arrays. We can start polling the heap
        int[] result = new int[totalLength];
        int index = 0;
        while (!minHeap.isEmpty()) {
            Element element = minHeap.poll();
            result[index++] = element.value;
            // Fill the empty space in the heap with the next element
            // in the array where the polled element comes from
            if (element.indexInArray <
                    arrayOfArrays[element.indexOfArray].length - 1) {
                int indexOfArray = element.indexOfArray;
                int indexInArray = element.indexInArray + 1;
                minHeap.offer(new Element(
                        indexOfArray,
                        indexInArray,
                        arrayOfArrays[indexOfArray][indexInArray]
                ));
            }
        }
        return result;
    }
}

class Element implements Comparable<Element> {
    int indexOfArray;
    int indexInArray;
    int value;

    Element(int indexOfArray, int indexInArray, int value) {
        this.indexOfArray = indexOfArray;
        this.indexInArray = indexInArray;
        this.value = value;
    }

    @Override
    public int compareTo(Element other) {
        if (this.value == other.value) {
            return 0;
        }
        return this.value < other.value ? -1 : 1;
    }
}
