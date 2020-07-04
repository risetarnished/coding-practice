# Stack With min()

[https://app.laicode.io/app/problem/32](https://app.laicode.io/app/problem/32)

## Description

    Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.


    pop() - remove and return the top element, if the stack is empty, return -1

- push(int element) - push the element to top
- top() - return the top element without remove it, if the stack is empty, return -1
- min() - return the current min value in the stack.

Medium

Stack

## Assumption

- All elements in the stack are integers.
- The two stacks are not null.
- The min stack can never be empty if the stack is not empty.

## Solution

### High-level Idea

- A direct but naive solution
  - When pushing a new element onto the stack, check the element against the minStack's top, push whichever is the smaller one on to the minStack
  - The drawback of this method is that the size of the minStack will be the same as the main stack. Moreover, even if we only push the element onto the minStack when it is smaller than the current min, in the case where there are a lot of duplicate elements, it still takes up a lot of space
- An improved method
  - Only push the new element onto the minStack when it is smaller than the minStack's top
    - Remember the size of the stack when pushing it onto the minStack
  - If popping the stack makes the stack's size smaller than the size of it when the current min was pushed onto the minStack, also pop the minStack

### Code

#### Direct method

```java
public class Solution {
  private Deque<Integer> stack;
  private Deque<Integer> minStack;

  public Solution() {
    // write your solution here
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    // Also pop the minStack
    stack.pollFirst();
    minStack.pollFirst();
  }

  public void push(int element) {
    stack.offerFirst(x);
    // Push the new element onto the minStack if it is smaller
    if (minStack.isEmpty() || x < minStack.peekFirst()) {
      minStack.offerFirst(x);
    } else {
      minStack.offerFirst(minStack.peekFirst());
    }
  }

  public int top() {
    return stack.isEmpty() ? Integer.MIN_VALUE : stack.peekFirst();
  }

  public int getMin() {
    return minStack.isEmpty() ? Integer.MIN_VALUE : minStack.peekFirst();
  }
}
```

#### Improved method

```java
public class Solution {
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

  public Solution() {
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
```

### Complexity

#### Direct method

- Time
  - Each `push()` and `pop()` call takes O(1) time
- Space
  - If n elements get pushed onto the stack, there are n elements pushed onto the minStack, as well
  - O(2n)

#### Improved method

- Time
  - Each `push()` and `pop()` call takes O(1) time
- Space
  - The minStack will take less space than the stack
  - O(< 2n)
