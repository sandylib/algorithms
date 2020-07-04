ublic class Solution {
  static int ROWS;
  static int COLS;

  public void solve(char[][] board) {
    if (board == null || board.length == 0) return ;
      
    this.ROWS = board.length;
    this.COLS = board[0].length;
	
    // Step 1). Call dfs for border cells and mark the escaped cells
    for (int r = 0; r < this.ROWS; ++r) {
        dfs(board, r, 0);
        dfs(board, r, this.COLS - 1);
    }
    for (int c = 0; c < this.COLS; ++c) {
        dfs(board, 0, c);
        dfs(board, this.ROWS - 1, c);
    }

    // Step 2). Flip the cells to their correct final states
    for (int r = 0; r < this.ROWS; ++r) {
      for (int c = 0; c < this.COLS; ++c) {
        if (board[r][c] == 'O') board[r][c] = 'X';
        if (board[r][c] == 'E') board[r][c] = 'O';
      }
    }
  }

  protected void dfs(char[][] board, int row, int col) {
    if(row < 0 || row > this.ROWS - 1 || col < 0 || col > this.COLS - 1 || board[row][col] != 'OSu') return ;

    board[row][col] = 'E';
    dfs(board, row, col + 1);
    dfs(board, row + 1, col);
    dfs(board, row, col - 1);
    dfs(board, row - 1, col);
  }
}