<!----- Conversion time: 0.782 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 18:45:15 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1zMmvq3c_hxc5ukBqWWbqzJVK0LgcfJ5R5eNXd4QqnfM
----->



# Stack With min()

[https://app.laicode.io/app/problem/32](https://app.laicode.io/app/problem/32)


## Description


    Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.


    pop() - remove and return the top element, if the stack is empty, return -1



*   push(int element) - push the element to top
*   top() - return the top element without remove it, if the stack is empty, return -1
*   min() - return the current min value in the stack.

Medium

Stack


## Assumption



*   All elements in the stack are integers.
*   The two stacks are not null.
*   The min stack can never be empty if the stack is not empty.


## Algorithm



1.  Method 1: use a helper class to store the size when the element gets added
    1.  When an element is pushed onto the stack, we also push an object of Element onto the minStack and keep track of the sizes of the two
    1.  When an element is popped from the stack, we check the stack size and see if it is greater than the minStack's top element's _sizeWhenAdded_ field. If the min value was added when the stack had a smaller size, it suggests that we are not popping the min value off yet. Otherwise, we need to pop the minStack since the min value is being popped from the stack
1.  Method 2: compare the sizes directly
    1.  When an element is being popped from the stack, check the size of minStack. The rest of the logic is same as step b in the first method.


## Solution


### Code


#### Method 1


```java
public class Solution {
  private LinkedList<Integer> stack;
  private LinkedList<Element> minStack;

  // Element class is used to store the min value and the size of the stack when it gets added to the minStack
  // We can also use a third stack to keep track of the size added
  // That saves the work for the Element class
  private class Element {
    private int val;
    private int sizeWhenAdded;
    private Element(int val, int sizeWhenAdded) {
      this.val = val;
      this.sizeWhenAdded = sizeWhenAdded;
    }
  }

  public Solution() {
    // write your solution here
    stack = new LinkedList<>();
    minStack = new LinkedList<>();
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    if (minStack.peek().sizeWhenAdded >= stack.size()) {
      minStack.pop();
    }
    return stack.pop();
  }

  public void push(int element) {
    if (stack.isEmpty() || element < minStack.peek().val) {
      minStack.push(new Element(element, stack.size() + 1));
    }
    stack.push(element);
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }

  public int min() {
    if (stack.isEmpty()) {
      return -1;
    }
    return minStack.peek().val;
  }
}
```



#### Method 2


```java
public class Solution {
  // This method does not use a helper class to store
  // extra information of the added elements
  private Deque<Integer> stack;
  private Deque<Integer> minStack;

  public Solution() {
    // write your solution here
    stack = new LinkedList<>();
    minStack = new LinkedList<>();
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    // If the sizes of the two stacks are equal, indicating
    // the element to be popped is the min value of the
    // current stack, it needs to be popped from the minStack
    // as well
    if (minStack.size() >= stack.size()) {
      minStack.pollLast();
    }
    return stack.pollLast();
  }

  public void push(int element) {
    // If this element is less than everything else
    // add it to the minStack
    if (stack.isEmpty() || element < minStack.peekLast()) {
      minStack.offerLast(element);
    }
    stack.offerLast(element);
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peekLast();
  }

  public int min() {
    if (minStack.isEmpty()) {
      return -1;
    }
    return minStack.peekLast();
  }
}
```



### Complexity

Time: operations (push, pop, etc.) are all native stack operations ⇒ O(1)

Space: two stacks are used ⇒ O(n)


<!-- GD2md-html version 1.0β13 -->
