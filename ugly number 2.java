import java.util.*;

class Solution {
  public int nthUglyNumber(int n) {
      int[] base = new int[] { 2,3,5};
      Comparator<Integer> comp = (x,y) -> x - y;
      PriorityQueue<Integer> minHeap = new PriorityQueue(comp);
      minHeap.add(1);
      
      for(int count = 1; count < n; count++) {
          int v = minHeap.remove();
          for(int b : base){
              if(Integer.MAX_VALUE / b > v ){
                  int newValue = v * b;
              
                  if(!minHeap.contains(newValue)){
                   minHeap.add(newValue);
                  }
              }    
          }
      }
      
      return minHeap.remove();
  }
}

class Solution {
  public int nthUglyNumber(int n) {
      if(n <= 6) return n;
      int[] ugly = new int[n];
      ugly[0] = 1;
      int i2 = 0, i3 = 0, i5 = 0, index = 1;
      while(index < n){
          int n2 = 2*ugly[i2], n3 = 3*ugly[i3], n5 = 5*ugly[i5];
          int temp = Math.min(n2, Math.min(n3, n5));
          ugly[index++] = temp;
          if(temp == n2) i2++;
          if(temp == n3) i3++;
          if(temp == n5) i5++;
      }
      return ugly[n-1];
  }
}