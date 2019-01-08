<!----- Conversion time: 1.691 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Mon Jan 07 2019 18:50:47 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=16ij037HINciwZLGuOdBS0IA0DMhrR2kDmDvhRPJhTfU
----->



# Combinations of Coins

[https://app.laicode.io/app/problem/73](https://app.laicode.io/app/problem/73)


## Description

Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

Arguments



*   coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
*   target - a non-negative integer representing the target number of cents, eg. 99

Assumptions



*   coins is not null and is not empty, all the numbers in coins are positive
*   target >= 0
*   You have infinite number of coins for each of the denominations, you can pick any number of the coins.

Return



*   a list of ways of combinations of coins to sum up to be target.
*   each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.

Examples

coins = {2, 1}, target = 4, the return should be

\[

  \[0, 4\],   (4 cents can be conducted by 0 _2 cents + 4 _1 cents)

  \[1, 2\],   (4 cents can be conducted by 1 _2 cents + 2 _1 cents)

  \[2, 0\]    (4 cents can be conducted by 2 _2 cents + 0 _1 cents)

\]

_Medium_

_Depth First Search_

_Recursion_


## Assumption

The target amount of money should not be negative.


## Algorithm

DFS, but there are two ways of thinking



---


![algorithm](algorithm.png "algorithm")


---


Looks like the second method is overwhelmingly preferred. So, only this method is implemented.


## Solution


### Code


```java
public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (target < 0 || coins == null || coins.length == 0) {
      return result;
    }
    combineCoins(target, coins, 0, new ArrayList<>(), result);
    return result;
  }

  private void combineCoins(int target, int[] coins, int index,
                            List<Integer> combination,
                            List<List<Integer>> result) {
    // Base case: when we have checked all choices of coins
    if (index == coins.length) {
      // Termination condition:
      // When the current combination adds up to the target
      if (target == 0) {
        result.add(new ArrayList<>(combination));
      }
      // Otherwise, ignore this combination
      return;
    }
    // At the current level, using the current coin of choice,
    // we can take 0, 1, 2, ..., up to target / coin_value
    // amount of this coin
    int currentCoin = coins[index];
    int max = target / currentCoin;
    for (int i = 0; i <= max; i++) {
      combination.add(i);
      // Update the remaining amount of target and move on
      // The next level will be the next coin
      combineCoins(target - i * currentCoin, coins, index + 1,
                   combination, result);
      // Backtracking
      combination.remove(combination.size() - 1);
    }
  }
}
```


_The **base case** section can be further optimized with a little trick:_



*   _We can terminate one level above such that we can avoid useless branches at the last level._
    *   _e.g., target remaining = 99, coin = 1_
    *   _this will result in 99 branches if we explore the last level_
    *   _however, if test to see if 99/1 number of 1 cent add up to 99 cents, we can directly conclude with that amount_
*   _Because at index == coins.length - 1, we are picking the last coin we can use. All we need to do (and actually only do) is to count the possible amount of this coin that we can take to fulfill target / currentCoin_
*   _Therefore, this section can be optimized to be:_

```java
if (index == coins.length - 1) {
  if (target % coins[index] == 0) {
    combination.add(target / coins[index]);
    result.add(new ArrayList<>(combination));
    combination.remove(combination.size() - 1);
  }
  return;
}
```



Full code with this implementation


```java
public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (target < 0 || coins == null || coins.length == 0) {
      return result;
    }
    combineCoins(target, coins, 0, new ArrayList<>(), result);
    return result;
  }

  private void combineCoins(int target, int[] coins, int index,
                            List<Integer> combination,
                            List<List<Integer>> result) {
    // Base case: when we get to choose the last coin
    if (index == coins.length - 1) {
      // Termination condition:
      // When a certain amount of the last coin adds up to the target
      if (target % coins[index] == 0) {
        combination.add(target / coins[index]);
        result.add(new ArrayList<>(combination));
        combination.remove(combination.size() - 1);
      }
      // Otherwise, ignore this combination
      return;
    }
    // At the current level, using the current coin of choice,
    // we can take 0, 1, 2, ..., up to target / coin_value
    // amount of this coin
    int currentCoin = coins[index];
    int max = target / currentCoin;
    for (int i = 0; i <= max; i++) {
      combination.add(i);
      // Update the remaining amount of target and move on
      // The next level will be the next coin
      combineCoins(target - i * currentCoin, coins, index + 1,
                   combination, result);
      // Backtracking
      combination.remove(combination.size() - 1);
    }
  }
}
```



### Complexity


#### Time

The number of levels of the recursion tree is determined by the number of coins options we can choose from (e.g., coins = \[25, 10, 5, 1\] gives us 4 different coins to choose from, so there are in total 4 levels). The exact number of levels is _coins.length_ == n

At each level, we need to consider _(target / coins\[index\])_ number of states. That is, the number of possible combinations consist of taking this coin at most. E.g., target = 99, coin = 25, at this level, we would consider 99 / 25 = 3 states (to take 0, 1, 2, or 3 of those 25 cents). Thus, the worst case is when we are trying to get the coin with the least amount to work ⇒ target = 99, coin = 1 cent ⇒ 99 states

Therefore, the time complexity is O(target/coins\[index\] ^ n), where coins\[index\] is the smallest amount among the coins. In the example, it is O(99 ^ 4).


#### Space

The number of levels in the recursion tree is dependent on the number of coins to select from ⇒ O(n).


<!-- GD2md-html version 1.0β13 -->
