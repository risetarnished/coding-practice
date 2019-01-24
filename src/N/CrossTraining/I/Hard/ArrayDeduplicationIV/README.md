<!----- Conversion time: 0.778 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Thu Jan 24 2019 02:02:04 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1jCfbrKSB1bR-Mingyu1-LbAiFgoJLb9MTuRuSK3mpiI
----->



# Array Deduplication IV

[https://app.laicode.io/app/problem/118](https://app.laicode.io/app/problem/118)


## Description

Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions



*   The given array is not null

Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}

Hard

Array

Stack




## Assumption

Because any element that has a count of 2 or more cannot exist in the array, the array we are interested in should be not null and have at least 1 element.


## Algorithm

This problem is almost the same as the _[Remove Adjacent Repeated Characters IV](../../../../../J/String/I/Hard/RemoveAdjacentRepeatedCharactersIV)_.

We will use a stack because we are comparing the element pointed to by the fast pointer to the first element in the "useless" section. We are looking back constantly. Therefore, we need a stack. Instead of implemented an actual stack using LinkedList or ArrayDeque, we can simply use a pointer and part of the original array to function as if there were a stack.

Everything to the left of the stack pointer, including itself, is considered to be in the result.

For example,

array = {1, 2, 3, 3, 3, 2, 2}

stack    s

fast        f

Step 1:

S is the stack pointer. The stack top is array\[0] at the beginning. Because array\[fast] != stack top ⇒ increment slow and copy array\[fast] to array\[slow]. Then push this element to the stack ⇒ s++


    array = {1, 2, 3, 3, 3, 2, 2}


    stack       s


    fast           f


    result  {1, 2}

Step 2:

Similar to Step 1 because array\[fast] != array\[stack]


    array = {1, 2, 3, 3, 3, 2, 2}


    stack          s


    fast              f

	result  {1, 2, 3}

Step 3:

Because array\[fast] == array\[stack], we need to check if there are any more of this element (while (fast < array.length - 1 && array\[fast] == array\[fast + 1]). If so, we skip all of them and pop the stack ⇒ s--


    array = {1, 2, 3, 3, 3, 2, 2}


    stack          s


    fast              f →f


    result  {1, 2, 3}

⇒


    array = {1, 2, 3, 3, 3, 2, 2}


    stack       s


    fast                    f


    result  {1, 2}

Step 4:

array\[fast] == array\[stack] again, we check the proceeding elements and skip any more duplicates. Pop the stack top at the end.


    array = {1, 2, 3, 3, 3, 2, 2}


    stack       s


    fast                    f → f


    result  {1, 2}

⇒


    array = {1, 2, 3, 3, 3, 2, 2}


    stack    s


    fast                    f → f


    **result  {1}**




## Solution


### Code


```java
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if (array == null || array.length <= 1) {
      return array;
    }
    // Use a pointer to make array[0, pointer] mimick a stack
    int stack = 0;
    for (int i = 1; i < array.length; i++) {
      if (stack < 0 || array[i] != array[stack]) {
        // stack.isEmpty() || different elements
        // stack.push(new element);
        array[++stack] = array[i];
      } else {
        // Skip consecutive duplications
        while (i < array.length - 1 && array[i] == array[i + 1]) {
          i++;
        }
        // stack.pop();
        stack--;
      }
    }
    // array[0, stack] is the result
    return Arrays.copyOf(array, stack + 1);
  }
}
```



### Complexity

Time: one iteration over all the elements in the array ⇒ O(n)

Space: O(1)


<!-- Docs to Markdown version 1.0β14 -->
