import java.util.Arrays;

public class countSquares {
  public int countSquaresOne(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    int res = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(i == 0 || j == 0){
                dp[i][j] = matrix[i][j];
            }
            else{
                dp[i][j] = matrix[i][j] == 1 ? Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1 : 0;
            }
            res += dp[i][j];
        }
    }
    
    return res;
}


public int countSquaresTwo(int[][] matrix) {
  int m = matrix.length, n = matrix[0].length;
  int[][] dp = new int[2][n];
  int res = 0;
  int flag = 1;
  for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
          if(i == 0 || j == 0){
              dp[flag][j] = matrix[i][j];
          }
          else{
              dp[flag][j] = matrix[i][j] == 1 ? Math.min(dp[flag ^ 1][j], Math.min(dp[flag ^ 1][j - 1], dp[flag][j - 1])) + 1 : 0;
          }
          res += dp[flag][j];
      }
      flag ^= 1;
  }
  
  return res;
}

public int countSquares3(int[][] matrix) {
  int n = matrix.length;
  int m = matrix[0].length;
  int[][] dp = new int[n+1][m+1];

  int ans =0;
  for ( int i =0 ; i < n ; i++)
      for ( int j =0 ; j < m ; j++)
          if ( matrix[i][j] == 1){
              dp[i+1][j+1] = 1 + Math.min(dp[i][j] , Math.min(dp[i+1][j] , dp[i][j+1]));
              ans+= dp[i+1][j+1];
          }
  return ans;
  
}
  
}