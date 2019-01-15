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

    // Rabin-Karp algorithm
    public int rabinKarp(String large, String small) {
        if (large == null || small == null) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        } else if (large.length() < small.length()) {
            return -1;
        }
        // Declare a large prime number as module end
        int largePrime = 101;
        // Because the character set may be very large, i.e. 1,112,064 if using UTF
        // We also need a small prime number to compute the hash value
        int smallPrime = 31;
        int seed = 1;
        // Hash value is computed using the small prime and mod large prime
        // hash_value = (s0*smallPrime^k + s1*smallPrime^(k-1) + ... + sk*smallPrime^0) % largePrime
        int targetHash = small.charAt(0) % largePrime;
        // For the rest of the chars in the string
        // Calculate the final hash value using a rolling hash method
        for (int i = 1; i < small.length(); i++) {
            seed = moduleHash(seed, 0, smallPrime, largePrime);
            targetHash = moduleHash(targetHash, small.charAt(i), smallPrime, largePrime);
        }
        // Compute each substring's hash value in the large string
        // Compute the first substring with the small string's length inside the large string
        int hash = 0;
        for (int i = 0; i < small.length(); i++) {
            hash = moduleHash(hash, large.charAt(i), smallPrime, largePrime);
        }
        if (hash == targetHash && strEquals(large, 0, small)) {
            return 0;
        }
        // Starting from the second character in large, check every substring
        for (int i = 1; i < large.length() - small.length() + 1; i++) {
            // The hash value could not be negative
            hash = forcePositive(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), smallPrime, largePrime);
            // There might be hash collisions, so, we need to check if the strings are
            // really the same when their hash value matches
            // The probability of a hash collision is small (O(1))
            // So the complexity does not get increased
            if (hash == targetHash && strEquals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }

    private int moduleHash(int hash, int addition, int smallPrime, int largePrime) {
        return (hash * smallPrime % largePrime + addition) % largePrime;
    }

    private boolean strEquals(String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(start + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int forcePositive(int hash, int largePrime) {
        if (hash < 0) {
            hash += largePrime;
        }
        return hash;
    }
}
