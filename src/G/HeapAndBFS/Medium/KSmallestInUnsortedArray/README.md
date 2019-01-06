<!----- Conversion time: 0.717 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sun Jan 06 2019 02:45:56 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1zeR7zEZtOWKpciBRIc8WDcwG4XwBrNtHhWkHT0Dnloc
----->



# K Smallest In Unsorted Array

[https://app.laicode.io/app/problem/25](https://app.laicode.io/app/problem/25)


## Description

Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

Assumptions



*   A is not null
*   K is >= 0 and smaller than or equal to size of A

Return



*   an array with size K containing the K smallest numbers in ascending order

Examples



*   A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}

Medium

Heap

Partition

Sort


## Assumption

The input array should not be null and should have at least K elements.


## Algorithm



1.  Maintain a min heap of size n
    1.  Heapify the entire array ⇒ O(n)
    1.  Call pop() k times to get the k smallest elements ⇒ O(k log(n))
        1.  pop() causes percolate down which takes O(log(n)) time
    1.  Total time complexity is O(n + k log(n))
1.  Maintain a max heap of size k
    1.  Heapify the first k elements in the array ⇒ O(k)
    1.  Iterate over the rest (n - k) elements
        1.  compare the top element (largest among the k in the current heap) to the incoming element
        1.  if the element is greater than the top → ignore it
        1.  if the element is smaller than the top → substitute the top with it
    1.  Total time complexity is O((n - k) log(k))

_I personally prefer using max heap, so I will only implement a max heap method._


## Solution


### Code


```java
public class Solution {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        // 1. Assumption: the input array should not be null or empty
        // 2. Algorithm:
        //    Maintain a maxHeap of size k; offer the first k elements in the array to the heap;
        //    From the (k + 1)th element, compare the current element to the top of the heap:
        //    1. if current < top ==> poll the top and offer the current element
        //    2. otherwise, ignore this element and continue
        if (array == null || array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[] {};
        }
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        // Alternative way to create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                if (one.equals(two)) {
                    return 0;
                }
                return one > two ? -1 : 1;
            }
        });
        for (int element : array) {
            if (maxHeap.size() < k) {
                // Heapify the first k elements
                maxHeap.offer(element);
            } else if (maxHeap.peek() > element) {
                maxHeap.poll();
                maxHeap.offer(element);
            }
        }
        int[] result = new int[k];
        // Ascending order
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
```



### Complexity

Time:



1.  heapify the first k elements ⇒ O(k)
1.  iterate over the other (n - k) elements ⇒ O(n - k)
1.  substitute the top element with a smaller element ⇒ O(log(k))

⇒ O((n - k) log(k))

Space: a max heap of size k ⇒ O(k)


<!-- GD2md-html version 1.0β13 -->
