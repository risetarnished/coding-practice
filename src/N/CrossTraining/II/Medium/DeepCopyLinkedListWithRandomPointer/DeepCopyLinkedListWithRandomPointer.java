package N.CrossTraining.II.Medium.DeepCopyLinkedListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * DeepCopyLinkedListWithRandomPointer
 *
 * @author meng
 * @date 1/27/19
 */
public class DeepCopyLinkedListWithRandomPointer {
    /**
     * Deep copy a linked list whose nodes have an extra pointer
     * pointing to a random node in the list or null
     *
     * @param head The head node of the linked list
     * @return     A deep copy of the original linked list
     */
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here
        if (head == null) {
            return null;
        }
        // Use a HashMap to keep track of the generated nodes
        Map<RandomListNode, RandomListNode> generated = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        generated.put(head, newHead);
        RandomListNode curr = newHead;
        while (head != null) {
            // Copy the next node
            if (head.next != null) {
                if (!generated.containsKey(head.next)) {
                    generated.put(head.next, new RandomListNode(head.next.value));
                }
                curr.next = generated.get(head.next);
            }
            // Copy the random node
            if (head.random != null) {
                if (!generated.containsKey(head.random)) {
                    generated.put(head.random, new RandomListNode(head.random.value));
                }
                curr.random = generated.get(head.random);
            }
            head = head.next;
            curr = curr.next;
        }
        return newHead;
    }
}

class RandomListNode {
    int value;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomListNode that = (RandomListNode) o;
        return value == that.value &&
                Objects.equals(next, that.next) &&
                Objects.equals(random, that.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next, random);
    }
}