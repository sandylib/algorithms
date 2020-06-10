class Solution {
  public int[] countBits(int num) {
      int[] res = new int[num+1];
      for (int i = 0; i <= num; i++) {
          res[i] = count(i);
      }
      return res;
  }
  
  private int count(int i) {
      int count = 0;
      while (i != 0) {
          i = i & (i-1);
          count++;
      }
      return count;
  }



  public int[] countBits2(int num) {
    int ans[] = new int[num+1];
    for(int i = 0;i < ans.length;i++)
        ans[i] = Integer.bitCount(i);
      return ans;
  } 

//   In order to remove the least-significant bit for any number “n” just take its “and(&)” with “n - 1”.
//   Now since the numbers “n” and “( n & ( n - 1 ) )” differs only by one bit, we can use the result obtained for “( n & ( n - 1 ) )” and add one to it to obtain the result for “n”.
  public int[] countBits3(int num) {
    int[] ans = new int[num + 1];
    for(int i = 1; i < num + 1; i++) ans[i] = ans[i & (i - 1)] + 1;
    return ans;
  }

}


