package B.BinarySearch.Medium.SearchInUnknownSizedSortedArray;

import java.util.ArrayList;
import java.util.List;

// For simplicity, a Dictionary class is created directly instead of implementation of a Dictionary interface
public class Dictionary {
    // Use an ArrayList to mimic the function
    private List<Integer> dictionary;
    public Dictionary(List<Integer> dictionary) {
        this.dictionary = new ArrayList<>(dictionary);
    }

    public Integer get(int index) {
        if (dictionary == null || index > dictionary.size() - 1) {
            return null;
        }
        return dictionary.get(index);
    }
}
