import java.util.*;

class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)     {
      ArrayList<int[]>[]adj=new ArrayList[n];
      for(int i=0;i<n;i++){
          adj[i]=new ArrayList<int[]>();
      }
      for(int i=0;i<flights.length;i++){
          int u=flights[i][0];
          int v=flights[i][1];
          int cost=flights[i][2];
          adj[u].add(new int[]{v,cost});
      }
      int min_dist=Integer.MAX_VALUE;
      Queue<int[]>q=new LinkedList<>();
      q.add(new int[]{src,0});
      int steps=0;
      while(!q.isEmpty()){
          int size=q.size();
          for(int i=0;i<size;i++){ 
          int []rv=q.poll();
         //   if(steps-1>K){break;} 
          if(rv[0]==dst){
              min_dist=Math.min(rv[1],min_dist);
          }
          for(int nei[]:adj[rv[0]]){
              if(rv[1]+nei[1]>min_dist){continue;}
              q.add(new int[]{nei[0],rv[1]+nei[1]});
          }
      }  
  if(steps++>K){break;}
         
      }
  
      return min_dist==Integer.MAX_VALUE?-1:min_dist;
  }

  public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
    int max = (int)1e9 + 7;
    int[][] cost = new int[n][n];
    int min = max;
    for(int i =0; i < cost.length; i++)
        for(int j = 0; j < cost.length; j++)
            cost[i][j] = max;
    cost[src][0] = 0;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < flights.length; j++){
            int[] flight = flights[j];
            int from = flight[0];
            int to = flight[1];
            int w = flight[2];
            for(int k = 1; k < n; k++){
                if(cost[from][k-1] + w < cost[to][k])
                    cost[to][k] = cost[from][k-1] + w;
            }
        }
    }
   
    for(int i = 0; i <= K+1; i++){
        if(i < cost[dst].length)
            min = Math.min(min,cost[dst][i]);
    }
    return min == max ? -1 : min;
}
  
}


