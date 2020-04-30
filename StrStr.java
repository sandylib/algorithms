

class Solution {
  public int strStr(String haystack, String needle) {
      int h = haystack.length();
      int n = needle.length();
      int ans = -1;
      
      int pos = 0; //needle cursor
      int i;
      for(i = 0; i<h && pos != n; i++){
          char c1 = haystack.charAt(i);
          char c2 = needle.charAt(pos);
          if(c1 == c2){
              pos++;
          }else{
              i -= pos;
              pos = 0;
          }
      }
      if(pos == n){
          ans = i - n;
      }
      return ans;
  }


  public int strStr2(String haystack, String needle) {
    if (needle.length() == 0)   return 0;
    if (needle.length() > haystack.length())    return -1;
    
    char[] h = haystack.toCharArray();
    char[] n = needle.toCharArray();
    for (int i = 0; i < h.length; i++) {
        int pos = i, j = 0;
        while (i < h.length && h[i++] == n[j++])
            if (j == n.length)    
                return pos;
        i = pos;
        
        // early return
        if (h.length - i == n.length)
            return -1;
    }
    
    return -1;
  }
}