import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class SolutionOne {
  public int[][] kClosest(int[][] points, int K) {
      Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
      return Arrays.copyOfRange(points, 0, K);
  }
}


class SolutionTwo {
  public int[][] kClosest(int[][] points, int K) {
      PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
      for (int i = 0; i < points.length; i++) {
          pq.add(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], points[i][0], points[i][1]});
      }
      int[][] result = new int[K][2];
      int i = 0;
      while (i < K) {
          int[] item = pq.poll();
          result[i][0] = item[1];
          result[i][1] = item[2];
          i++;
      }
      return result;
  }
}