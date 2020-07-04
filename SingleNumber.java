/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * 
 * Notes:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
class Solution {
  public int singleNumber(int[] nums) {
      int  x = 0;

      for(int n : nums ){
        x = x^n;
      }

      return x;
  }
}


class Solution {
  public int singleNumber(int[] nums) {
      int ones = 0;
      int twos = 0;
      int not_threes = 0;
      for(int n : nums) {
          twos |= (ones & n);
          ones ^= n;
          not_threes = ~(ones & twos);
          ones &= not_threes;
          twos &= not_threes;
      }
      
      return ones;
  }
}

class Solution {
  public int singleNumber(int[] nums) {
      HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
      for(int n : nums) {
          if(!hm.containsKey(n))
              hm.put(n,1);
          else
              hm.put(n,hm.get(n)+1);
      }
      for(Map.Entry<Integer,Integer> entry : hm.entrySet()) {
          if(entry.getValue()==1)
              return entry.getKey();
      }
      return 0;
  }
}