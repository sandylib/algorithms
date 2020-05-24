import java.util.ArrayList;

class Solution {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
      int i = 0, j = 0;
      ArrayList<int[]> res = new ArrayList<>();
      while(i < A.length && j < B.length){
          int l1 = Math.max(A[i][0], B[j][0]);
          int l2 = Math.min(A[i][1], B[j][1]);
          if(A[i][1] < B[j][0] || B[j][1] < A[i][0]){
              l1 = 0;
              l2 = 0;
          }
          if(l1 != 0 || l2 != 0)
              res.add(new int[]{l1, l2});
          if(A[i][1] < B[j][1])
              i++;
          else
              j++;
      }
      return res.toArray(new int[res.size()][]);
  }
}