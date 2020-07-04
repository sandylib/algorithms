import java.util.*;

class Solution {
  public int[] prisonAfterNDays(int[] cells, int N) {
    Set<String> seen = new HashSet<>();
    int count = 0;
    boolean hasCycle = false;
    for (int i = 0; i < N; i++) {
        int[] next = next(cells);
        String str = Arrays.toString(next);
        if (seen.contains(str)) {
            hasCycle = true;
            break;
        } else {
            seen.add(str);
            count++;
        }
        cells = next;
    }
    
    if (hasCycle) {
        
        int times = N % count;
        for (int i = 0; i < times; i++) {
            cells = next(cells);
        }
        return cells; 
    }

    return cells;
}

private int[] next(int[] cells) {
    int[] next = new int[cells.length];
    for (int i = 1; i < cells.length - 1; i++) {
        next[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
    }
    return next;
}

}


class Solution {
  public int[] prisonAfterNDays(int[] cells, int N) {
      
      if (N>14) N = N%14 + 14;
      else N = N%14;
      
      for(int i = 0; i < N; i++) {
          int[] temp = new int[cells.length];
          for(int j = 1; j < 7; j++){
              temp[j] = cells[j-1] == cells[j+1] ? 1 : 0;
          }
          cells = temp;
      }
      return cells;
  }
}