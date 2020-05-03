import java.util.Arrays;

class Solution {
  public int countPrimes(int n) {
    int c = 0;
    boolean primes[] = new boolean[n];
    Arrays.fill(primes, true);

    for (int i = 2; i < n; i++) {
      if (primes[i] == true) {
        for (int j = 2; i * j < n; j++) {
          primes[i * j] = false;
        }
      }
    }
    for (int i = 2; i < n; i++) {
      if (primes[i] == true)
        c++;
    }
    return c;
  }
}

