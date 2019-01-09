<!----- Conversion time: 1.062 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Mon Jan 07 2019 02:26:41 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1yKTnfttnPPBMeFMViY2qAVjENhUxIhaxiakHLQU5eZw
----->



# All Subsets I

[https://app.laicode.io/app/problem/62](https://app.laicode.io/app/problem/62)


## Description

Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions



*   There are no duplicate characters in the original set.

​Examples



*   Set = "abc", all the subsets are \["", "a", "ab", "abc", "ac", "b", "bc", "c"\]
*   Set = "", all the subsets are \[""\]
*   Set = null, all the subsets are \[\]

Medium

Depth First Search

Recursion


## Assumption

The input string (character set) should not be null and should have some characters in it


## Algorithm

[Depth First Search](https://en.wikipedia.org/wiki/Depth-first_search)

DFS classical process:

E.g. if the input is "abc"



1.  What does it store on each level?
    1.  Three levels in total. In each level, we need to decide whether to put this character into the result set or not.
1.  How many different states should we try in this level?
    1.  Two states. In each level, we need to choose to
        1.  select this character and put it into the result
        1.  skip this character and move on to the next level


## Solution


### Method 1


#### Code


```java
public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    findSubsets(set.toCharArray(), result, 0, new StringBuilder());
    return result;
  }

  private void findSubsets(char[] chars,
                           List<String> result,
                           int index,
                           StringBuilder stringBuilder) {
    if (index == chars.length) {
      result.add(stringBuilder.toString());
      return;
    }
    // Case 1: add the char at current level
    //         and look for the next level
    stringBuilder.append(chars[index]);
    findSubsets(chars, result, index + 1, stringBuilder);
    // Case 2: not add the char, and look for the next level
    // Need to remove the added char from case 1 - back track
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    findSubsets(chars, result, index + 1, stringBuilder);
  }
}
```


The DFS part can be simplified a little bit:




```java
    // Case 1: not add the char, proceed to the next level
    findSubsets(chars, result, index + 1, stringBuilder);
    // Case 2: add the char, proceed to the next level
    findSubsets(chars, result, index + 1, stringBuilder.append(chars[index]));
    // Back tracking remove the added char
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
```



#### Complexity

Time

There are n levels, and in each level we have two different states to consider ⇒ O(2^n)

Space

The recursion tree has n levels on the call stack ⇒ O(n)


### Method 2


#### Code


```java
public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    findSubsets(set.toCharArray(), result, 0, new StringBuilder());
    return result;
  }

  private void findSubsets(char[] chars,
                           List<String> result,
                           int index,
                           StringBuilder stringBuilder) {
    result.add(stringBuilder.toString());
    for (int i = index; i < chars.length; i++) {
      stringBuilder.append(chars[i]);
      findSubsets(chars, result, i + 1, stringBuilder);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
  }
}
```



#### Complexity

Time

There are n levels, and in each level we have two different states to consider ⇒ O(2^n)

Space

The recursion tree has n levels on the call stack ⇒ O(n)




## Additional Information

A similar problem on lintcode:

[https://www.lintcode.com/problem/subsets/description](https://www.lintcode.com/problem/subsets/description)


#### **Description**

Given a set of distinct integers, return all possible subsets.



*   Elements in a subset must be in _non-descending_ order.
*   The solution set must not contain duplicate subsets.

Have you met this question in a real interview?  Yes


#### **Example**

If S = \[1,2,3\], a solution is:

\[ \
  \[3\], \
  \[1\], \
  \[2\], \
  \[1,2,3\], \
  \[1,3\], \
  \[2,3\], \
  \[1,2\], \
  \[\] \
\]


#### **Challenge**

Can you do it in both recursively and iteratively?




```java
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        findAllSubsets(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void findAllSubsets(int[] nums,
                                List<Integer> subset,
                                int index,
                                List<List<Integer>> result) {
        // Add the current element to the result
        result.add(new ArrayList<>(subset)); // deep copy
        // For each level, check the two states: select/not select
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            findAllSubsets(nums, subset, i + 1, result);
            // back tracking
            subset.remove(subset.size() - 1);
        }
    }
}
```



<!-- GD2md-html version 1.0β13 -->
