package H.DFS.Medium.CombinationsOfCoins;

import java.util.ArrayList;
import java.util.List;

/**
 * https://app.laicode.io/app/problem/73
 *
 * Description
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents),
 * get all the possible ways to pay a target number of cents.
 *
 * Arguments
 *
 * coins - an array of positive integers representing the different denominations of coins, there
 * are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
 * target - a non-negative integer representing the target number of cents, eg. 99
 * Assumptions
 *
 * coins is not null and is not empty, all the numbers in coins are positive
 * target >= 0
 * You have infinite number of coins for each of the denominations, you can pick any number of the coins.
 * Return
 *
 * a list of ways of combinations of coins to sum up to be target.
 * each way of combinations is represented by list of integer, the number at each index means the
 * number of coins used for the denomination at corresponding index.
 * Examples
 *
 * coins = {2, 1}, target = 4, the return should be
 *
 * [
 *
 *   [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
 *
 *   [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
 *
 *   [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
 *
 * ]
 */

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 0 || coins == null || coins.length == 0) {
            return result;
        }
        List<Integer> combination = new ArrayList<>();
        combineCoins(target, coins, 0, combination, result);
        return result;
    }

    private void combineCoins(int target, int[] coins, int index,
                              List<Integer> combination,
                              List<List<Integer>> result) {
        /*
        // Base case: when we finish picking the coins
        if (index == coins.length) {
            // Terminate when we have used the coins to meet the target amount
            if (target == 0) {
                result.add(new ArrayList<>(combination));
            }
            // Otherwise, this combination does not add up to the target amount
            return;
        }
        */
        // A better way to terminate
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
        // In the current level
        // For each coin amount (coins[index]), we may choose to use 0, 1, 2, ...,
        // up to (target / coin amount) number of it
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            combination.add(i);
            // Update the remaining amount of target and move on
            // The next level uses another coin (coins[index + 1])
            combineCoins(target - i * coins[index], coins, index + 1,
                    combination, result);
            // Backtracking
            combination.remove(combination.size() - 1);
        }
    }
}
