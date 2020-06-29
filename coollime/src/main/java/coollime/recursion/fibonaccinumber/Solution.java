package coollime.recursion.fibonaccinumber;

public class Solution {

  public long fibonacci(int K) {
    if (K == 0) {
      return 0;
    } else if (K == 1) {
      return 1;
    }
    return fibonacci(K - 1) + fibonacci(K - 2);
  }
}
