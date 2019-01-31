package N.CrossTraining.II.Medium.MergeKSortedLists;

import helper.ListNode.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * MergeKSortedLists
 *
 * @author meng
 * @date 1/28/19
 */
public class MergeKSortedLists {
    /**
     * Merge K sorted lists into one big sorted list in ascending order
     *
     * @param listOfLists The K sorted lists in ascending order
     * @return            A list of all elements in listOfLists sorted in ascending order
     */
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here
        if (listOfLists == null || listOfLists.isEmpty()) {
            return null;
        }
        // Use a min heap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                listOfLists.size(),
                (one, two) -> {
                    if (one.value == two.value) {
                        return 0;
                    }
                    return one.value < two.value ? -1 : 1;
                }
        );
        // Offer the head nodes of each list to the heap to get started
        for (ListNode head : listOfLists) {
            // Skip any empty lists
            if (head == null) {
                continue;
            }
            minHeap.offer(head);
        }
        // Use a dummy node to keep track of the result
        ListNode result = new ListNode(0);
        ListNode current = result;
        // Get the min node from the heap each time
        // Fill the empty spot with the next node in that list
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            current.next = min;
            // Fill the empty spot with the next node
            if (min.next != null) {
                minHeap.offer(min.next);
            }
            current = current.next;
        }
        return result.next;
    }
}
