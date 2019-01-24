<!----- Conversion time: 0.718 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Jan 21 2019 20:29:55 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1DfBUlKdPHXkVLrgomyFVG3WKqbh0nAMkFCMboLtDvMc
----->



# 95 Percentile

[https://app.laicode.io/app/problem/114](https://app.laicode.io/app/problem/114)


## Description

Given a list of integers representing the lengths of urls, find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).

Assumptions



*   The maximum length of valid url is 4096
*   The list is not null and is not empty and does not contain null

Examples



*   \[1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.

Medium

Array

Math


## Assumption

As stated in the description


## Algorithm

[Percentile](https://en.wikipedia.org/wiki/Percentile)



1.  Solution 0
    1.  sort by length ⇒ O(n log(n))
    1.  pick urls\[ceiling(95% * n) - 1]
1.  Solution 1
    1.  max heap (~95%) + min heap (~5%)
    1.  for each step ⇒ O(log(n))
    1.  total time ⇒ O(n log(n))
1.  Solution 2
    1.  key insight: max length of URLs <= 4096
    1.  Data structure:
        1.  similar to bucket sort
        1.  bucket\[0] = the # of URLs of length 0
        1.  bucket\[1] = the # of URLs of length 1
        1.  …
        1.  bucket\[4096] = the # of URLs of length 4096
    1.  Algorithm
        1.  for each url, insert it into the bucket ⇒ O(n)
        1.  find the min L such that sum(buckets\[0...L]) >= 0.95n ⇒ O(4096) ⇒ O(1)
    1.  What is [Bucket Sort](https://en.wikipedia.org/wiki/Bucket_sort)?
        1.  Sort all URLs by length
            1.  bucket\[0]: url1 → url3 → url5 → url8
            1.  bucket\[1]: url9
            1.  bucket\[2]: url10 → url11 → url12
            1.  …
            1.  bucket\[4096]: url1024
        1.  url1 → url3 → url5 → url8 → url9 → url10 → url11 → url12 → … → url1024


## Solution


### Code


```java
public class Solution {
  public int percentile95(List<Integer> lengths) {
    // Write your solution here.
    if (lengths == null || lengths.isEmpty()) {
      return 0;
    }
    // The max length of valid url is 4096
    int maxLength = 4096;
    int[] count = new int[maxLength + 1];
    for (int length : lengths) {
      count[length]++;
    }
    int sum = 0;
    while (sum <= 0.05 * lengths.size()) {
      sum += count[maxLength--];
    }
    return maxLength + 1;
  }
}
```



### Complexity


#### Time

Bucket sort all n URL lengths in the list ⇒ O(n)


#### Space

An array used for bucket sort ⇒ O(n)


<!-- Docs to Markdown version 1.0β14 -->
