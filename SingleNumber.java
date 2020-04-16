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