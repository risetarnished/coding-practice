<!----- Conversion time: 0.682 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 18:43:22 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1J3m24b1h_llHrp6nxiBKVEb3gwa1oYodaNS7OKHc0Yk
----->



# Queue by Two Stacks

[https://app.laicode.io/app/problem/31](https://app.laicode.io/app/problem/31)


## Description


    Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.


    C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and pop() operations. When the queue is empty, front() should return -1.


    Assumptions



*   The elements in the queue are all Integers.
*   size() should return the number of elements buffered in the queue.
*   isEmpty() should return true if there is no element buffered in the queue, false otherwise.

Medium

Queue

Stack


## Assumption

Refer to the assumptions in description.


## Algorithm

By using two FILO stacks, we can definitely implemented a FIFO queue.

(addFirst(e)/pollFirst() and addLast(e)/pollLast() will both work. Just need to stick to one pair consistently)



*   the first stack is used for offering new elements
    *   stackOne | ← 1 ← 2 ← 3 | stack top
*   the second stack is used for polling
    *   stackTwo | ← 3 ← 2 ← 1 | stack top

When new elements are added to the _queue_, we call stackOne.addFirst(e).

When we need to poll the _queue_ and get the least recently added element, we poll the first element from stackTwo. If stackTwo is empty, we need to transfer the elements on stackOne to stackTwo by pushing the elements popped from stackOne one at a time. Therefore, the order that the elements are offered to and polled from the _queue_ are accordance to FIFO.


## Solution


### Code


```java
public class Solution {
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
```



### Complexity


#### Time

Enqueue: simply pushing elements onto stackOne ⇒ O(1)

Dequeue:



*   Best-case: directly pop the top of stackTwo ⇒ O(1)
*   Worst-case: move all elements on stackOne to stackTwo and pop ⇒ O(n)
*   Amortized:
    *   1st call (triggers the transfer) ⇒ n * stackOne.pop() + n * stackTwo.push + 1
    *   2nd call (directly pop) ⇒ 1
    *   3rd call (directly pop) ⇒ 1
    *   …
    *   1000th call (directly pop) ⇒ 1
    *   ((2n + 1) + 1 * (n - 1)) / n = 3n/n = 3
    *   Thus, amortized-time complexity of dequeue ⇒ O(3) = O(1)


#### Space

Two stacks of size n are used ⇒ O(n).


<!-- GD2md-html version 1.0β13 -->
