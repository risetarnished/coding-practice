<!----- Conversion time: 0.704 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sat Jan 12 2019 17:09:49 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1aAoHeUvMX0as9OC5Dgnc1Ltb9xpo4zhZCF065YVkbqM
----->



# ReOrder Array

[https://app.laicode.io/app/problem/197](https://app.laicode.io/app/problem/197)


## Description

Given an array of elements, reorder it as follow:



*   { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
*   { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

Try to do it in place.

Assumptions



*   The given array is not null

Examples



*   { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
*   { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
*   { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }


## Assumption

The input array is not null


## Algorithm



1.  The problem needs to be divided into two situations: odd vs even
    1.  if there are even number of elements in the array/string, we will reorder them all
    1.  if there are odd number of elements, we can leave the last element out of the reordering process because it will eventually end up at the very last position
1.  E.g. input = [ABCDEFG1234567]
    1.  find the mid point of the array

            0 1 2 **3** 4 5 6   7 8 9 **0** 1 2 3

        1.  A B C D E F G | 1 2 3 4 5 6 7
    1.  find the left/right mid points in the subarray
        1.  A B C **D** E F G | 1 2 3 **4** 5 6 7
    1.  reverse(left_mid, mid-1), reverse(mid, right_mid-1)
        1.  A B C **G F E D** | **3 2 1 **4 5 6 7
    1.  reverse(left_mid, right_mid-1)
        1.  A B C **1 2 3 **| **D E F G **4 5 6 7
    1.  reorder(0, 2 * left_mid - 1), reorder(2 * left_mid, end)


## Solution


### Code


```java
public class Solution {
  public int[] reorder(int[] array) {
    // Write your solution here
    if (array == null || array.length < 2) {
      return array;
    }
    // If the array has an odd length
    // Ignore the last element and reorder the rest of it
    if (array.length % 2 != 0) {
      reorderArray(array, 0, array.length - 2);
    } else {
      reorderArray(array, 0, array.length - 1);
    }
    return array;
  }

  private void reorderArray(int[] array, int left, int right) {
    int length = right - left + 1;
    // Base case: when the subarray has less than 2 elements
    if (length <= 2) {
      return;
    }
    // Make sure the mid points divides the chunks correctly
    // 0 1 2 3 4 5 6 | 7 8 9 0 1 2 3
    // A B C D E F G | 1 2 3 4 5 6 7
    // chunk 1: A B C
    // chunk 2: D E F G
    // chunk 3: 1 2 3
    // chunk 4: 4 5 6 7
    // Only in this way can chunk 1 and 3, 2 and 4 match up each other
    int mid = left + length / 2;
    int lmid = left + length / 4;
    int rmid = left + length * 3 / 4;
    // I love Google trick
    reverse(array, lmid, mid - 1);
    reverse(array, mid, rmid - 1);
    reverse(array, lmid, rmid - 1);
    // lmid - left == size of left / 2
    reorderArray(array, left, left + (lmid - left) * 2 - 1);
    reorderArray(array, left + (lmid - left) * 2, right);
  }

  private void reverse(int[] array, int left, int right) {
    while (left < right) {
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}
```



### Complexity


#### Time

Reversing operations in each subarray ⇒ O(n)

There are log(n) levels in total

⇒ O(nlog(n))


#### Space

Recursion tree has log(n) levels ⇒ O(log(n))


<!-- GD2md-html version 1.0β13 -->
