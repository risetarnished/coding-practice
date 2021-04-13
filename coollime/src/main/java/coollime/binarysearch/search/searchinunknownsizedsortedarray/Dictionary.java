package coollime.binarysearch.search.searchinunknownsizedsortedarray;

import java.util.ArrayList;
import java.util.List;

/**
 * For simplicity, a Dictionary class is created directly instead of
 * implementation of a Dictionary interface
 */
class Dictionary {
    /**
     * Use an ArrayList to mimic the function
     */
    private List<Integer> dict;

    public Dictionary(List<Integer> dictionary) {
        this.dict = new ArrayList<>(dictionary);
    }

    public Integer get(int index) {
        if (dict == null || index > dict.size() - 1) {
            return null;
        }
        return dict.get(index);
    }
}
