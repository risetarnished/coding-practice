package D.QueueAndStack.Medium.StackWithMin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description
 * Enhance the stack implementation to support min() operation. min() should return the current minimum value in the
 * stack. If the stack is empty, min() should return -1.
 * <p>
 * pop() - remove and return the top element, if the stack is empty, return -1
 * <p>
 * push(int element) - push the element to top
 * top() - return the top element without remove it, if the stack is empty, return -1
 * min() - return the current min value in the stack.
 */

public class StackWithMin {
  private Deque<Integer> stack;
  private Deque<Element> minStack;

  /**
   * The helper class to represent the pairs of
   * <element, size of the stack when it gets pushed>
   */
  private class Element {
    int val;
    int size;

    private Element(int val, int size) {
      this.val = val;
      this.size = size;
    }
  }

  public StackWithMin() {
    // write your solution here
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    // If the size of the stack will become smaller than it used to be when
    // the current min was pushed, also pop the minStack
    if (stack.size() == minStack.peekFirst().size) {
      minStack.pollFirst();
    }
    return stack.pollFirst();
  }

  public void push(int element) {
    stack.offerFirst(element);
    // If the element is smaller than the current min,
    // also push it onto the minStack
    if (minStack.isEmpty() || element < minStack.peekFirst().val) {
      minStack.offerFirst(new Element(element, stack.size()));
    }
  }

  public int top() {
    return stack.isEmpty() ? -1 : stack.peekFirst();
  }

  public int min() {
    return minStack.isEmpty() ? -1 : minStack.peekFirst().val;
  }
}

/*
 * Time complexity: native push and pop operations of stack ==> O(1)
 *
 * Space complexity: two stacks are used ==> O(n)
 */
