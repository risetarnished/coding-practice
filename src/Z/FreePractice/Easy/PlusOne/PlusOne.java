package Z.FreePractice.Easy.PlusOne;

public class PlusOne {
  public int[] plus(int[] digits) {
    // Write your solution here
    if (digits == null || digits.length == 0) {
      return digits;
    }
    // carry represents the fact whether the previous digits yielded a carry-over 10
    boolean hasCarry = false;
    for (int i = digits.length - 1; i >= 0; i--) {
      // Add 1 to the digit if
      // 1. it is the least significant digit
      // 2. there was a carry
      if (i == digits.length - 1 || hasCarry) {
        digits[i] += 1;
      }
      hasCarry = digits[i] >= 10;
      digits[i] %= 10;
    }
    // Post-processing
    // If the most significant digit yielded a carry-over
    // We need to create a new digit and expand the array
    if (hasCarry) {
      int[] expanded = new int[digits.length + 1];
      for (int i = 0; i < expanded.length; i++) {
        if (i == 0) {
          expanded[i] = 1;
        } else {
          expanded[i] = digits[i - 1];
        }
      }
      digits = expanded;
    }
    return digits;
  }
}
