package I.HashTable.Medium.TopKFrequentWords;

import java.util.*;

/**
 * https://app.laicode.io/app/problem/67
 *
 * Description
 * Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.
 *
 * Assumptions
 *
 * the composition is not null and is not guaranteed to be sorted
 * K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
 * Return
 *
 * a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
 * Examples
 *
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
 */

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if (k < 0) {
            return new String[] {};
        }
        if (combo == null || combo.length == 0) {
            return combo;
        }
        // Count the frequency of each string in the input
        // Use a HashMap to store the <word, frequency> relationship
        Map<String, Integer> frequency = getFrequencyMap(combo);
        // Use a min heap of size k to store the k most frequent words
        Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (one, two) -> {
            if (one.getValue().equals(two.getValue())) {
                return 0;
            }
            return one.getValue() < two.getValue() ? -1 : 1;
        });
        return getTopKWords(frequency, minHeap, k);
    }

    private Map<String, Integer> getFrequencyMap(String[] combo) {
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
        // K could be larger than the actual number of distinct words in the map
        // So the size of the result array should be determined by the size of
        // the min heap rather than its capacity (k)
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
