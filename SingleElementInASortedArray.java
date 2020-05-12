class Solution {
  public int singleNonDuplicate(int[] nums) {
    int out = nums[0];

		for (int i = 1; i < nums.length; i++) {
			out = out ^ nums[i];

		}

		return out;
   
  }

  
}