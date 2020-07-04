import java.util.*;

class Solution 
{
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<Integer>();
        int[] factorial = new int[n + 1];
        StringBuilder builder = new StringBuilder();
    
        // create an array of factorial lookup
        int i, index, product = 1;
        factorial[0] = 1;
        for(i = 1; i <= n; i++){
            product *= i;
            factorial[i] = product;
        }
        
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
    
        // create a list of numbers to get indices
        for(i = 1; i <= n; i++){
            numbers.add(i);
        }
        
        // numbers = {1, 2, 3, 4}
    
        k--;
       
	   // check for what positions the element at index will be at first, second positions etc based on factorials
        for(i = 1; i <= n; i++){
            index = k / factorial[n - i];
            builder.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= (index * factorial[n - i]);
        }
    
        return builder.toString();
    }
}

class Solution {
  int count =0;
  String res;
  public String getPermutation(int n, int k) {
      StringBuilder track = new StringBuilder();
      return helper(n,k,new boolean[n],track);
  }
  //only get Kth path(track)
  private String helper(int n, int k, boolean[] used, StringBuilder track){
      if(track.length()==n) {
          count++;//number of valid track
          if(count==k){
             res= track.toString();
          }
      }
     
      for(int i=1;i<=n;i++){
          if(count>=k) break;//count>=k stop traverse
          if(!used[i-1]){
              used[i-1] =true;
              track.append(i);
              helper(n,k,used,track);
              used[i-1]= false;
              track.deleteCharAt(track.length()-1);
              
          }
      }
      return res;
  }
}

class Solution {
  public String getPermutation(int n, int k) {
      List<String> table = new LinkedList<>(map(n));
      if(n==1) return table.get(0);
      k--;
      String ans = "";
      while(n>0){
          int kth = kth(n--);
          int at = k/kth;
          k%=kth;
          ans += table.get(at);
          table.remove(at);
      }

      return ans;
  }
  public List<String> map(int n){
      String s="1,2,3,4,5,6,7,8,9";
      List<String> list = Arrays.asList(s.split(","));
      return list;
  }
  public int kth(int n ){
      int t =1;
      for(int i=1; i<n; i++){
          t*=i;
      }
      return t;
  }
}