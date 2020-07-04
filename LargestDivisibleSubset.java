import java.util.*;

class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Map<Integer, List<Integer>> hm = new HashMap();
    Arrays.sort(nums);
    List<Integer> ans = new ArrayList();
    for(int i=0;i<nums.length;i++){
        int max = 0;
        int val = 0;
        for(int j=1;j*j<=nums[i];j++){
            if(nums[i] % j == 0){
                if(hm.containsKey(nums[i]/j)){
                    if(max < hm.get(nums[i]/j).size()){
                        max = hm.get(nums[i]/j).size();
                        val = nums[i]/j;
                    }
                }
                if(hm.containsKey(j)){
                    if(max < hm.get(j).size()){
                        max = hm.get(j).size();
                        val = j;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList();
        if(max != 0){
            list.addAll(hm.get(val));
        }
        list.add(nums[i]);
        hm.put(nums[i], list);
        if(ans.size() < list.size()){
            ans = list;
        }
    }
    return ans;
  }


  public List<Integer> largestDivisibleSubset2(int[] nums) {
    if(nums.length == 0){
        return new ArrayList<>();
    }
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int[] parent = new int[nums.length];
    Arrays.fill(parent, -1);
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if((nums[i] % nums[j] == 0) && dp[i] < dp[j] + 1){
                dp[i] = dp[j] + 1;
                parent[i] = j;
            }
        }
    }
    int max = dp[0], pos = 0;
    for (int i = 1; i < nums.length ; i++) {
        if(dp[i] > max){
            max = dp[i];
            pos = i;
        }
    }
    List<Integer> res = new ArrayList<>();
    while (pos != -1){
        res.add(nums[pos]);
        pos = parent[pos];
    }
    Collections.reverse(res);
    return res;
}
}