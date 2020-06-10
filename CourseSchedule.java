import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

class Solution {
  public boolean canFinish(int n, int[][] pre) {

// creating the graph structure
      List<List<Integer>> graph=new ArrayList<>();
      for(int i=0;i<n;i++)
          graph.add(new ArrayList<>());			        
      for(int []pr:pre)
          graph.get(pr[0]).add(pr[1]);
    
  int []vis=new int [n];
  // for 0<=i<n, vis[i] contains 3 values.
  // vis[i]=0, if the node is not visited yet.
  // vis[i]=-1, if the DFS exploration has started for the i-th node but not yet completed.
  // vis[i]=1, if the DFS exploration has both started for the i-th node and completed.
  
  
  // Checking for each component of the graph. This is necessary because the graph is directed and also the graph may not be a connected graph.		
      for(int i=0;i<n;i++)
          if(vis[i]==0&&!visit(graph,i,vis))
              return false;
      
      return true;
  } 

// The following function returns false iff a cycle is found involving the current node or any node that can be reached starting from the current node, else returns true.

  public boolean visit(List<List<Integer>> graph, int i,int []vis){
      vis[i]=-1; // started exploring.
      for(int n: graph.get(i))
  // if we find vis[n]==-1, this means there is a cycle involving this node in the graph, because we can reach the current node from the node n, and also we can reach node n from the current node, in a directed graph, so there is definitely a cycle.
  // we will only explore if vis[n]==0, or the node n has not been explored.
          if(vis[n]==-1||vis[n]==0&&!visit(graph,n,vis)) 
              return false;
      vis[i]=1;        // exploration of the current node is complete.
      return true; // returning true because no cycle is present involving this node or any node that can be reached from this node.
  }
}
///

class SolutionDAG {
  List<Integer>[] graph;
    boolean[] visited;
    boolean[] explored;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean isCyclic(int u){
        visited[u] = true;
        for(Integer v : graph[u]){
            if(!visited[v]){
                if(isCyclic(v)){
                    return true;
                }
            }
            else if(!explored[v]){
                return true;
            }
        }
        explored[u] = true;
        return false;
    }
}

//
class SolutionDAGGraph {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      Graph graph = new Graph(numCourses, prerequisites);
      return graph.isDAG();
  }
  
  private static class Graph {
      private int[] inputs;
      private List<List<Integer>> edges;
      
      public Graph(int number, int[][] edges) {
          this.inputs = new int[number];
          this.edges = new ArrayList<>();
          for (int i = 0; i < number; i++) {
              this.edges.add(new ArrayList<>());
          }
          
          for (int[] edge : edges) {
              inputs[edge[0]]++;
              this.edges.get(edge[1]).add(edge[0]);
          }
      }
      
      public boolean isDAG() {
          Queue<Integer> queue = new LinkedList<>();
          for (int i = 0; i < inputs.length; i++) {
              if (inputs[i] == 0) {
                  queue.add(i);
              }
          }
          
          while (!queue.isEmpty()) {
              int current = queue.poll();
              for (int neighbour : edges.get(current)) {
                  if (--inputs[neighbour] == 0) {
                      queue.add(neighbour);
                  }
              }
          }
          
          return IntStream.of(inputs).sum() == 0;
      }
  }
}
///

class SolutionINdegree {
  
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      int n = numCourses;
      int[] indegree = new int[n];
      Map<Integer,List<Integer>> edge = new HashMap<>();
      for(int[] pr : prerequisites){
          List<Integer> l =  edge.getOrDefault(pr[1], new ArrayList<>());
          l.add(pr[0]); indegree[pr[0]]++;
          edge.put(pr[1], l);
      }
      Queue<Integer> q = new LinkedList<>();
      int count = 0;
      for(int i = 0; i < indegree.length; i++){
          if(indegree[i] == 0) q.add(i); 
      }

      while(!q.isEmpty()){

          int cur = q.poll();

          if(indegree[cur] == 0) count++;

          if(!edge.containsKey(cur)) continue;

          for(int nei : edge.get(cur)){
              indegree[nei]--;
              if(indegree[nei]== 0) q.add(nei);
          }

      }

      return count == n;
  }
}