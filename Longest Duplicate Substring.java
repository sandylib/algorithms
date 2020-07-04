import java.util.*;


class Solution {
  private static final long q = (1 << 31) - 1;
  private static final long R = 256;
      
  public String longestDupSubstring(String S) {      
      int left = 2;
      int right = S.length() - 1;
      int start = 0;
      int maxLen = 0;
      
      while (left <= right) {
          int len = left + (right - left) / 2;
          boolean found = false;
          
          Map<Long, List<Integer>> map = new HashMap<>();
          long hash = hash(S, len);
          map.put(hash, new ArrayList<>());
          map.get(hash).add(0);
          long RM = 1l;
          for (int i = 1; i < len; i++) RM = (R * RM) % q;
          
          loop:
          for (int i = 1; i + len <= S.length(); i++) {
              hash = (hash + q - RM * S.charAt(i - 1) % q) % q;
              hash = (hash * R + S.charAt(i + len - 1)) % q;
              if (!map.containsKey(hash)) {
                  map.put(hash, new ArrayList<>());
              } else {
                  for (int j : map.get(hash)) {
                      if (compare(S, i, j, len)) {
                          found = true;
                          start = i;
                          maxLen = len;
                          break loop;
                      }
                  }
              }
              map.get(hash).add(i);
          }
          if (found) left = len + 1;
          else right = len - 1;
      }
      
      return S.substring(start, start + maxLen);
  }
  
  private long hash(String S, int len) { 
      long h = 0;
      for (int j = 0; j < len; j++) h = (R * h + S.charAt(j)) % q;
      return h;
  }
  
  private boolean compare(String S, int i, int j, int len) {
      for (int count = 0; count < len; count++) {
          if (S.charAt(i++) != S.charAt(j++)) return false ; 
      }
      return true ; 
  }
}


class Solution {
    public int search(int L, int a, long modulus, int n, int[] nums) {
    // compute the hash of string S[:L]
    long h = 0;
    for(int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

    // already seen hashes of strings of length L
    HashSet<Long> seen = new HashSet();
    seen.add(h);
    // const value to be used often : a**L % modulus
    long aL = 1;
    for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

    for(int start = 1; start < n - L + 1; ++start) {
      // compute rolling hash in O(1) time
      h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
      h = (h + nums[start + L - 1]) % modulus;
      if (seen.contains(h)) return start;
      seen.add(h);
    }
    return -1;
  }
  
    public String longestDupSubstring(String S) {
      int n = S.length();
      // convert string to array of integers
      // to implement constant time slice
      int[] nums = new int[n];
      for(int i = 0; i < n; ++i) nums[i] = (int)S.charAt(i) - (int)'a';
      // base value for the rolling hash function
      int a = 26;
      // modulus value for the rolling hash function to avoid overflow
      long modulus = (long)Math.pow(2, 32);

      // binary search, L = repeating string length
      int left = 1, right = n;
      int L;
      
      while (left != right) {
        L = left + (right - left) / 2;
        if (search(L, a, modulus, n, nums) != -1) left = L + 1;
        else right = L;
      }

      int start = search(left - 1, a, modulus, n, nums);
      return start != -1 ? S.substring(start, start + left - 1) : "";
    }
}