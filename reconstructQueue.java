import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public int[][] reconstructQueue(int[][] people) {
      Arrays.sort(people, (a,b) -> a[0]!=b[0] ? b[0]-a[0] :a[1]-b[1]);
      List<int[]> list = new LinkedList<>();
      for(int[] x: people){
          list.add(x[1],x);
      }
      return list.toArray(new int[people.length][]);   
  }
}