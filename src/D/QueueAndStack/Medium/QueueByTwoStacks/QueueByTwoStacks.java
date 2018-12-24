package D.QueueAndStack.Medium.QueueByTwoStacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description
 * Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and
 * peek() operations. When the queue is empty, poll() and peek() should return null.
 *
 * C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and
 * pop() operations. When the queue is empty, front() should return -1.
 *
 * Assumptions
 *
 * The elements in the queue are all Integers.
 * size() should return the number of elements buffered in the queue.
 * isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 **/

public class QueueByTwoStacks {
    // Set up two stacks
    private Deque<Integer> stackOne;
    private Deque<Integer> stackTwo;

    public QueueByTwoStacks() {
        // Write your solution here
        // The 1st stack is used only when we need to add in new elements
        // The 2nd stack is used only when we need to poll or peek the first element
        stackOne = new LinkedList<>();
        stackTwo = new LinkedList<>();
    }

    public Integer poll() {
        // When there are elements in the 2nd stack --> poll directly
        // Otherwise, transfer all elements from the 1st stack to the 2nd stack and poll
        if (stackTwo.isEmpty()) {
            transferStack();
        }
        return stackTwo.pollFirst();
    }

    public void offer(int element) {
        stackOne.addFirst(element);
    }

    public Integer peek() {
        if (stackTwo.isEmpty()) {
            transferStack();
        }
        return stackTwo.peekFirst();
    }

    public int size() {
        return stackOne.size() + stackTwo.size();
    }

    public boolean isEmpty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }

    private void transferStack() {
        while (!stackOne.isEmpty()) {
            stackTwo.addFirst(stackOne.pollFirst());
        }
    }
}
