
public class HappyNumber {
  public boolean isHappy(int n) {
      
    HashSet<Integer> seem = new HashSet();
    
    while(n!=1){
      
      int sum = 0;
      int curr = n;
      
      while(curr != 0) {
         sum += (curr%10) * (curr%10);
         curr /=10;
      }
        
      if(seem.contains(sum)) {
          return false;
      }
        
      seem.add(sum);
      n = sum;
      
    }
    
    return true;
      
  }

}