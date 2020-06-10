import java.util.Arrays;

class Solution {
  public int twoCitySchedCost(int[][] costs) {
      int N = costs.length/2;

      int[] refund = new int[N * 2];

      int cityA = 0, cityB = 0;

      int minCost = 0, index = 0;

      for(int[] cost : costs){
          refund[index++] = cost[1] - cost[0];
          minCost += cost[0];
      }

      Arrays.sort(refund);

      for(int i = 0; i < N; i++){
          minCost += refund[i];
      }
      return minCost;
  }
}


class Solution {
  public int twoCitySchedCost(int[][] costs) {
      // sort in ascending order of(diff of costs of flying to 2 cities)
      Arrays.sort(costs,(x, y)->{            
       return (x[0] - x[1]) - (y[0] - y[1]);
     });
      
     int i = 0, j = costs.length - 1;
     int sum = 0;
     while(i < j) {
       sum += costs[i][0] + costs[j][1];
         ++i;
         --j;
      }
      
     return sum;
  }
}