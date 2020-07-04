class Solution {
  public int numTrees(int n) {
      if(n == 1) return 1;
      int[] dp = new int[n+1];
      dp[1] = 1;
      for(int i = 2; i <= n; i++){
          dp[i] = 2 * dp[i-1];
          for(int j = 2; j <= i-1; j++){
              dp[i] += dp[j-1]*dp[i-j];
          }
      }
      return dp[n];
  }
}

class Solution {
  public int numTrees(int n) {
  
     if( n == 1 || n == 0)
       return 1;
      
     int[] catalans = new int[n+1];
      catalans[0] = 1;
      catalans[1] = 1;
      catalans[2] = 2;
  
      for (int i = 3; i <= n; i++) {
          int j = i - 1;
          int s = 0;
          int cat = 0;
          while (s < j) {
              cat += catalans[s++] * catalans[j--];
          }
          cat += cat;
  
          if (s == j) {
              cat += catalans[s] * catalans[s];
          }
          catalans[i] = cat;
      }   
      return catalans[n];
  }
  }