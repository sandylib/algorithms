import java.util.Arrays;

class Solution {
  private double[] probabilities;
  
  public Solution(int[] w) {
      double sum = 0;
      this.probabilities = new double[w.length];
      for(int weight : w)
          sum += weight;
      for(int i = 0; i < w.length; i++){
          w[i] += (i == 0) ? 0 : w[i - 1];
          probabilities[i] = w[i]/sum; 
      }
  }
   
  public int pickIndex() {
      return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
  }
}

class Solution {
    
  private List<Integer> list;
  private Random random;
  private int sum;
  
  public Solution(int[] w) {
    
      list   = new ArrayList<>();
      random = new Random();
      sum    = 0;
      
      list.add(0); 
      
      for(int num : w){
          
          sum += num;
          list.add(sum);
      }
  }
  
  public int pickIndex() {
      
      int index = Collections.binarySearch(list, random.nextInt(sum));
       /* 
         * https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#binarySearch
         * "the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1)"
         * if index < 0, return -(index + 1) - 1 => -(index + 2)
         */
      
      return index >= 0? index : -(index + 2);  
  }
}