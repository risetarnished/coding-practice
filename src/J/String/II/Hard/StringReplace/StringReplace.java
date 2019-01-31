package J.String.II.Hard.StringReplace;

/**
 * https://app.laicode.io/app/problem/172
 *
 * Description
 * Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
 *
 * Assumptions
 *
 * input, S and T are not null, S is not empty string
 * Examples
 *
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 */

public class StringReplace {
    public String replace(String input, String source, String target) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        // Because it is possible that source.length() < target.length()
        // We'd better use StringBuilder to avoid the overhead
        StringBuilder sb = new StringBuilder();
        // Check if source exists as a substring(s) in the input from fromIndex
        int fromIndex = 0;
        int matchIndex = input.indexOf(source, fromIndex);
        while (matchIndex != -1) {
            // matchIndex = index of the first occurrence of source in input
            // If we append input[fromIndex, matchIndex - 1]
            // we will safely skip the source
            sb.append(input, fromIndex, matchIndex).append(target);
            // Update fromIndex to skip the source in input
            fromIndex = matchIndex + source.length();
            // Look for the next occurrence of source in input
            matchIndex = input.indexOf(source, fromIndex);
        }
        // No (more) occurrences of source in input
        // append the (rest of) input to the result
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }

    // A naive way of using StringBuilder - clear thought flow
    public String replaceNaive(String input, String source, String target) {
        if (input == null || input.length() == 0) {
            return input;
        }
        StringBuilder output = new StringBuilder();
        int inputIndex = 0;
        while (inputIndex < input.length()) {
            // When we are not in the window that contains the source
            // Just copy whatever in the input to the output
            if (!isSubstring(input, inputIndex, source)) {
                output.append(input.charAt(inputIndex++));
                continue;
            }
            // Substring matches
            // Copy the target to the output
            for (int i = 0; i < target.length(); i++) {
                output.append(target.charAt(i));
            }
            // inputIndex pointer needs to move to the next "word"
            inputIndex += source.length();
        }
        return new String(output);
    }

    private boolean isSubstring(String input, int start, String source) {
        for (int i = 0; i < source.length(); i++) {
            if (start + i >= input.length()) {
                return false;
            }
            if (input.charAt(start + i) != source.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Avoid using StringBuilder ==> Use char[]
    public String replaceAlt(String input, String source, String target) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        // If source.length() >= target.length()
        // No need to worry about array's space
        if (source.length() >= target.length()) {
            return replaceDirectly(array, source, target);
        }
        // When target is longer than source, we need to allocate extra space
        return replaceWithExtraSpace(array, source, target);
    }

    private String replaceDirectly(char[] array, String source, String target) {
        // Because the original array has enough space to hold the result
        // simply use a two pointer method
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            // Check if fast points to an occurrence of source in input
            // If so, replace the substring with target
            if (isSubstring(array, fast, source)) {
                replaceSource(array, slow, target);
                slow += target.length();
                fast += source.length();
            } else {
                // If no occurrence of source is seen
                // Just copy fast to slow and move on
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }

    private String replaceWithExtraSpace(char[] array, String source, String target) {
        // Because we need a bigger sized array to hold the result
        // we need to know how many extra spaces needed
        // Count the # of occurrence of source in input
        int sourceCount = 0;
        for (int i = 0; i <= array.length - source.length(); i++) {
            if (isSubstring(array, i, source)) {
                sourceCount++;
                i += source.length() == 1 ? 0 : source.length();
            }
        }
        // Allocate enough space for the result array
        char[] result = new char[array.length +
                sourceCount * (target.length() - source.length())];
        // Two pointers:
        // 1. elements to the right of input is to be processed
        // 2. elements to the left of output is to be returned
        int inputPointer = 0;
        int outputPointer = 0;
        while (inputPointer < array.length) {
            if (isSubstring(array, inputPointer, source)) {
                replaceSource(result, outputPointer, target);
                inputPointer += source.length();
                outputPointer += target.length();
            } else {
                result[outputPointer++] = array[inputPointer++];
            }
        }
        return new String(result);
    }

    private boolean isSubstring(char[] array, int start, String source) {
        for (int i = 0; i < source.length(); i++) {
            if (start + i >= array.length) {
                return false;
            }
            if (array[start + i] != source.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void replaceSource(char[] array, int start, String target) {
        for (int i = 0; i < target.length(); i++) {
            array[start + i] = target.charAt(i);
        }
    }
}
