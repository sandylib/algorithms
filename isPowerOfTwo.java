class Solution {
  public boolean isPowerOfTwo(int n) {
      if (n <= 0) return false;
      while (n % 2 == 0) n /= 2;
      return n == 1;
  }
}

class Solution {
  public boolean isPowerOfTwo(int n) {
      return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo(n/2)));
  }
}


class Solution {
  public boolean isPowerOfTwo(int n) {
      return n > 0 && ((n & (n-1)) == 0);
  }
}

class Solution {
  public boolean isPowerOfTwo(int n) {
      return n > 0 && Integer.bitCount(n) == 1;
  }
}

