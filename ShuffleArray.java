import java.util.*;


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
class Solution {
  
  int[] original = null;
  int[] currNums = null;
  Random random = null;

  public Solution(int[] nums) {
      this.original = nums;
      this.currNums = nums.clone();
      this.random = new Random();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
      currNums = original.clone();
      return this.currNums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
      for(int i=0; i<currNums.length; i++){
          int temp = currNums[i];
          int idx = random.nextInt(currNums.length - i) + i;
          currNums[i] = currNums[idx];
          currNums[idx] = temp;
      }

      return currNums;
    }
}
