package D.QueueAndStack.Medium.SortWith3Stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description
 * Given one stack with integers, sort it with two additional stacks (total 3 stacks).
 *
 * After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
 *
 * Assumptions:
 *
 * The given stack is not null.
 * Requirements:
 *
 * No additional memory, time complexity = O(nlog(n)).
 */

public class SortWith3Stacks {
    /**
     * Given one stack with integers, sort it with two additional stacks (total 3 stacks)
     * After sorting, the original stack should contain the sorted integers
     * in ascending order from top to bottom
     *
     * @param s1  The given stack with integer elements to sort
     */
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        // Write your solution here
        // Corner cases
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        // Use merge sort method to sort the elements
        sortStack(s1, s2, s3, s1.size());
    }

    /**
     * Sort the elements in a given stack with the help of two additional stacks
     *
     * @param s1      The stack to sort
     * @param s2      The stack used as buffer
     * @param s3      The stack used to store the results temporarily
     * @param length  The length of the part in s1 that is left to get sorted
     */
    private void sortStack(Deque<Integer> s1, Deque<Integer> s2, Deque<Integer> s3, int length) {
        // Base case: if there are no more elements in s1 to be divided
        if (length <= 1) {
            return;
        }
        // Push half of the elements in s1 to s2
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        // Sort s1 and s2
        // s1 now has half of the original elements left
        sortStack(s1, s2, s3, length - half);
        sortStack(s2, s1, s3, half);
        // Merge the sorted stacks together
        mergeStacks(s1, s2, s3, length - half, half);
        // After sorting, s3 has all the original elements sorted in descending
        // order from top to bottom
        // Transfer the elements from s3 to s1 to get the expected result
        transferStacks(s3, s1, length);
    }

    /**
     * Merge sorted elements on two stacks onto another one
     *
     * @param s1         The first sorted stack
     * @param s2         The second sorted stack
     * @param s3         The stack to store the merged results
     * @param lengthOne  The length of sorted elements in s1
     * @param lengthTwo  The length of sorted elements in s2
     */
    private void mergeStacks(Deque<Integer> s1, Deque<Integer> s2, Deque<Integer> s3,
                             int lengthOne, int lengthTwo) {
        int one = 0;
        int two = 0;
        while (one < lengthOne && two < lengthTwo) {
            if (s1.peekFirst() < s2.peekFirst()) {
                s3.offerFirst(s1.pollFirst());
                one++;
            } else {
                s3.offerFirst(s2.pollFirst());
                two++;
            }
        }
        while (one < lengthOne) {
            s3.offerFirst(s1.pollFirst());
            one++;
        }
        while (two < lengthTwo) {
            s3.offerFirst(s2.pollFirst());
            two++;
        }
    }

    /**
     * Transfer elements from one stack to another
     *
     * @param s1      The given stack with elements to transfer
     * @param s2      The target stack for the elements
     * @param length  The length of the sorted part of the stack
     */
    private void transferStacks(Deque<Integer> s1, Deque<Integer> s2, int length) {
        for (int i = 0; i < length; i++) {
            s2.offerFirst(s1.pollFirst());
        }
    }
}
