class Solution {
  public int numIslands(char[][] grid) {
      int h = grid.length;
      if(h == 0) return 0;
      int l = grid[0].length;
      
      int result = 0;
      
      for(int i=0; i<h; i++) {
          for(int j=0; j<l; j++) {
              if(grid[i][j] == '1') {
                  DFS(grid, i, j);
                  result++;
              }
          }
      }
      
      return result;
  }
  
  public void DFS(char[][] grid, int row, int col) {
     int H = grid.length;
      if(H == 0) return;
     int L = grid[0].length;
      
      if(row < 0 || col < 0 || row >= H || col >= L || grid[row][col] != '1') {
          return;
      }
          
      grid[row][col] = '0';
      DFS(grid, row+1, col);
      DFS(grid, row-1, col);
      DFS(grid, row, col+1);
      DFS(grid, row, col-1);
      
  }
}