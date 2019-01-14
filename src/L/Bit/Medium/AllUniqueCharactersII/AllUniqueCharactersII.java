package L.Bit.Medium.AllUniqueCharactersII;

public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        // Write your solution here
        if (word == null || word.length() <= 1) {
            return true;
        }
        // Use an integer array that has enough bits to
        // represent the 256 ASCII characters
        int[] occurred = new int[256 / 32];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int row = ch / 32;
            int col = ch % 32;
            // See if the corresponding bit is 1
            if (((occurred[row] >> col) & 1) == 1) {
                return false;
            }
            // Mark the corresponding bit to 1
            occurred[row] |= 1 << col;
        }
        return true;
    }
}
