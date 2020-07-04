package coollime.queueandstack.stackwithmin;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  private Deque<Integer> stack;
  private Deque<Element> minStack;

  private class Element {
    int val;
    int size;

    private Element(int val, int size) {
      this.val = val;
      this.size = size;
    }
  }

  public Solution() {
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    if (stack.size() == minStack.peekFirst().size) {
      minStack.pollFirst();
    }
    return stack.pollFirst();
  }

  public void push(int element) {
    stack.offerFirst(element);
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
