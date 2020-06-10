class Solution {
  public void reverseString(char[] s) {
      helper(s, 0, s.length-1);
  }
  
  public void helper(char[] s, int left, int right){
    if(left >= right) return;
    char temp = s[left];
    s[left++] = s[right];
    s[right--]=temp;
    helper(s, left, right );
  }
}