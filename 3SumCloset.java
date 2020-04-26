
public class 3SumCloset {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
    
    int closestSum = nums[0] + nums[1] + nums[2];
    int minDiff = Math.abs(target - closestSum);
    
    for(int i = 0; i< nums.length -2; i++) {
      
      if(i>0 && nums[i] == nums[i-1]) {
          continue;
      }
      
      int l = i + 1;
      int r = nums.length -1;
      
      while( l < r) {
          int sum = nums[i] + nums[l] + nums[r];
        
          if(sum == target) {
            return target;
          }else if(sum < target) {
            l++;
          } else {
            r--;
          }
        
        if(Math.abs(target - sum) < minDiff) {
            closestSum = sum;
            minDiff = Math.abs(target - sum);
        }
      }
      
    }
    
    return closestSum;
  }

}