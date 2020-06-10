import java.util.ArrayList;
import java.util.List;

class Solution {
  
  public boolean possibleBipartition(int N, int[][] dislikes) {
      Node[] nodes = new Node[N+1];
      for (int i = 1; i <= N; i++)
          nodes[i] = new Node();
      
      for (int[] edge : dislikes) {
          int from = edge[0];
          int to = edge[1];
          
          nodes[from].addEdge(nodes[to]);
          nodes[to].addEdge(nodes[from]);
      }
      
      for (int idx = 1; idx <= N; idx++) {
          if (!nodes[idx].isColored() && !nodes[idx].dfs(Color.BLACK))
              return false;
      }
      
      return true;
  }
  
  private static enum Color { UNCOLORED, BLACK, WHITE };
  
  private static class Node {
      private Color color;
      private List<Node> neighbours;
      
      public Node() {
          color = Color.UNCOLORED;
          this.neighbours = new ArrayList<>();
      }
      
      public boolean isColored() {
          return this.color != Color.UNCOLORED;
      }
      
      public void addEdge(Node node) {
          this.neighbours.add(node);
      }
      
      public boolean dfs(Color color) {
          if (isColored()) {
              return this.color == color;
          }
          
          this.color = color;
          for (Node neighbour : neighbours) {
              if (!neighbour.dfs(color == Color.BLACK ? Color.WHITE : Color.BLACK))
                  return false;
          }
          
          return true;
      }
  }
}


///
class Solution {
  ArrayList<Integer>[] graph;
  Map<Integer, Integer> color;

  public boolean possibleBipartition(int N, int[][] dislikes) {
      graph = new ArrayList[N+1];
      for (int i = 1; i <= N; ++i)
          graph[i] = new ArrayList();

      for (int[] edge: dislikes) {
          graph[edge[0]].add(edge[1]);
          graph[edge[1]].add(edge[0]);
      }

      color = new HashMap();
      for (int node = 1; node <= N; ++node)
          if (!color.containsKey(node) && !dfs(node, 0))
              return false;
      return true;
  }

  public boolean dfs(int node, int c) {
      if (color.containsKey(node))
          return color.get(node) == c;
      color.put(node, c);

      for (int nei: graph[node])
          if (!dfs(nei, c ^ 1))
              return false;
      return true;
  }
}