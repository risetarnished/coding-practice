<!----- Conversion time: 0.891 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 08 2019 23:56:39 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1JanGBuAPI1BhSxpCBRMrCBzKUA_24NINcGdeBdY_66c
----->



# Top K Frequent Words

[https://app.laicode.io/app/problem/67](https://app.laicode.io/app/problem/67)


## Description

Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions



*   the composition is not null and is not guaranteed to be sorted
*   K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words

Return



*   a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)

Examples



*   Composition = \["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"\], top 2 frequent words are \["b", "c"\]
*   Composition = \["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"\], top 4 frequent words are \["b", "c", "a", "d"\]
*   Composition = \["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"\], top 5 frequent words are \["b", "c", "a", "d"\]

Medium

Hashtable

Heap

Partition

Sort


## Assumption

The input string array should not be null or empty and the value of k should be a positive integer.


## Algorithm

HashMap + Min Heap



1.  Iterate over the entire String array, one string at a time, counting the number of occurrence of each string. Store the <word, frequency> relationship in a HashMap
2.  Using a min heap of size k, for each entry in the HashMap, find the k most frequent words




## Solution


### Code


```java
public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here
    if (k < 0) {
      return new String[] {};
    }
    if (combo == null || combo.length == 0) {
      return combo;
    }
    // Count the frequency of each word in the input
    // Use a HashMap to store the <word, frequency> relationship
    Map<String, Integer> frequency = getFrequencyOfWords(combo);
    // Use a min heap of size k to store the k most frequent words
    Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
        k, new Comparator<Map.Entry<String, Integer>>() {
          @Override
          public int compare(Map.Entry<String, Integer> one,
                             Map.Entry<String, Integer> two) {
            if (one.getValue().equals(two.getValue())) {
              return 0;
            }
            return one.getValue() < two.getValue() ? -1 : 1;
          }
        }
    );
    return getTopKWords(frequency, minHeap, k);
  }

  private Map<String, Integer> getFrequencyOfWords(String[] combo) {
    Map<String, Integer> frequency = new HashMap<>();
    for (String word : combo) {
      frequency.put(word, frequency.getOrDefault(word, 0) + 1);
    }
    return frequency;
  }

  private String[] getTopKWords(Map<String, Integer> frequency,
                                Queue<Map.Entry<String, Integer>> minHeap,
                                int k) {
    for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry);
      } else if (entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    // K could be greater than the number of distinct words
    // So the size of the result array should be determined
    // by the size of the heap rather than its capacity
    String[] result = new String[minHeap.size()];
    for (int i = minHeap.size() - 1; i >= 0; i--) {
      result[i] = minHeap.poll().getKey();
    }
    return result;
  }
}
```



### Complexity


#### Time



1.  Get the frequency of each word: Iterate over all n strings in the array to get the frequency map ⇒ O(n)
2.  Get the most k frequent words from the min heap:
    1.  offer the first k entries to the heap ⇒ O(k)
    2.  update the heap when the incoming entry's value is greater than the top element's value on the heap ⇒ O(log(k))
    3.  in worst-scenario, all the rest of the strings could cause this update, (n - k) in total
    4.  O(k + (n - k) log(k))
3.  In total, O(n) + O((n - k) log(k)) ⇒ O((n - k) log(k))


#### Space

A map and a heap is used ⇒ O(n)


<!-- GD2md-html version 1.0β13 -->
