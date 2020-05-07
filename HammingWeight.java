public class HammingWeight {
    public int hammingWeight(int n) {
      int bits = 0;
      int mask = 1;
      for (int i = 0; i < 32; i++) {
          if ((n & mask) != 0) {
              bits++;
          }
          mask <<= 1;
      }
      return bits;
  }
}

The solution is straight-forward. We check each of the 32 bits of the number. If the bit is 11, we add one to the number of 11-bits.

We start with a mask m=1m=1, because the binary representation of 11 is,