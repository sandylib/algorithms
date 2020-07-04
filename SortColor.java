class Solution {
  public void swap(int[] nums, int a, int b){
      int temp = nums[a];
      nums[a] = nums[b];
      nums[b] = temp;
  }
  public void sortColors(int[] nums) {
      int left = 0, right = nums.length-1;
      for(int i=0;i<nums.length;i++){
          if(nums[i] == 2 && right!=i) swap(nums, i--, right--);
          else if(nums[i] == 0 && left!=i) swap(nums, i--, left++);
          if(i >= right) break;
      }
      
  }
}