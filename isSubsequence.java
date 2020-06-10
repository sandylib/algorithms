class Solution {
  public boolean isSubsequence(String s, String t) {
      int i = 0;
      int j = 0;
      while (i < s.length() && j < t.length()) {
          if (s.charAt(i) == t.charAt(j)) {
              i++;
          }
          j++;
      }

      return i == s.length();
  }
}

class Solution {
  public boolean isSubsequence(String s, String t) {
      return isSubsequence(s, t, 0, 0);
  }
  
  public boolean isSubsequence(String s, String t, int i, int j) {
      if(i == s.length()) return true;
      if(j == t.length()) return false;
      return s.charAt(i) == t.charAt(j) ? isSubsequence(s, t, i + 1, j + 1) : isSubsequence(s, t, i, j + 1);
  }
}