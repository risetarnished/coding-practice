package J.StringI.Medium.DetermineIfOneStringIsAnothersSubstring;

/**
 * https://app.laicode.io/app/problem/85
 *
 * Description
 * Determine if a small string is a substring of another large string.
 *
 * Return the index of the first occurrence of the small string in the large string.
 *
 * Return -1 if the small string is not a substring of the large string.
 *
 * Assumptions
 *
 * Both large and small are not null
 * If small is empty string, return 0
 * Examples
 *
 * “ab” is a substring of “bcabc”, return 2
 * “bcd” is not a substring of “bcabc”, return -1
 * "" is substring of "abc", return 0
 */

public class DetermineIfOneStringIsAnothersSubstring {
    public int strstr(String large, String small) {
        if (large == null || small == null ||
                large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        for (int i = 0; i < large.length() - small.length() + 1; i++) {
            for (int j = 0; j < small.length(); j++) {
                if (small.charAt(j) != large.charAt(i + j)) {
                    break;
                }
                if (j == small.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
