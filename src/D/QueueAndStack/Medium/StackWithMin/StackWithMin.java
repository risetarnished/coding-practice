package D.QueueAndStack.Medium.StackWithMin;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description
 * Enhance the stack implementation to support min() operation. min() should return the current minimum value in the
 * stack. If the stack is empty, min() should return -1.
 *
 * pop() - remove and return the top element, if the stack is empty, return -1
 *
 * push(int element) - push the element to top
 * top() - return the top element without remove it, if the stack is empty, return -1
 * min() - return the current min value in the stack.
 */

public class StackWithMin {
    // Declare two stacks: a "real" stack and a stack to store the current min value in the stack
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public StackWithMin() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        // If the popped elements equals to the current top of minStack, it needs to be popped from minStack, too
        if (stack.peekFirst().equals(minStack.peekFirst())) {
            minStack.pollFirst();
        }
        return stack.pollFirst();
    }

    public void push(int element) {
        // If this element is less than everything else (current min), push it onto the minStack
        // Caution: minStack can never be empty if stack is not empty
        if (stack.isEmpty() || element <= minStack.peekFirst()) {
            minStack.offerFirst(element);
        }
        stack.offerFirst(element);
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }
}

/*
 * Time complexity: native push and pop operations of stack ==> O(1)
 *
 * Space complexity: two stacks are used ==> O(n)
 */
