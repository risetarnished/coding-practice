package D.QueueAndStack.Medium.SortWith3Stacks;

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
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        // Write your solution here
        if (s1 == null || s1.isEmpty()) {
            return;
        }
        // Sort elements in s1 with the help of s2
        // S3 stores all the elements in descending order from top to bottom
        sort(s1, s2, s3);
        // Put all elements in s3 (descending order) back to s1 to meet the requirement --> ascending order (top to bottom)
        transferStack(s3, s1);
    }

    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3) {
        // Base case: when all the elements on s1 have been sorted and pushed onto s3 in descending order
        if (s1.isEmpty()) {
            return;
        }
        Integer min = s1.pollFirst();
        // Move elements from s1 to s2 while looking for a min value in the current iteration
        // Push the min value onto s3 and move the elements back to s1
        while (!s1.isEmpty()) {
            if (s1.peekFirst().compareTo(min) < 0) {
                // Push the old min onto s2, otherwise we will miss it
                s2.offerFirst(min);
                // Take the new min value out
                min = s1.pollFirst();
            } else {
                // Push the current element onto s2 directly
                s2.offerFirst(s1.pollFirst());
            }
        }
        // Upon exiting the while-loop, we have found the min value in this iteration
        // Push it onto s3 and the elements (if any) on s2 back to s1
        s3.offerFirst(min);
        // Trick: flip s2 and s1
        sort(s2, s1, s3);
    }

    private void transferStack(LinkedList<Integer> stackOne, LinkedList<Integer> stackTwo) {
        while (!stackOne.isEmpty()) {
            stackTwo.offerFirst(stackOne.pollFirst());
        }
    }
}

/**
 * Time complexity:
 * There are n levels in the recursion tree. We need to check all n elements in s1 in each level --> O(n^2)
 *
 * Space complexity:
 * s2 and s3 are two stacks being used --> O(n)
 */