
public class 4Sum {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		if (nums.length == 0)
			return ans;


		for (int i = 0; i < nums.length - 2; i++) {
			if (i - 1 >= 0 && nums[i - 1] == nums[i]) 
				continue;

			for (int j = nums.length - 1; j > i + 2; j--) {
				if (j + 1 <= nums.length - 1 && nums[j + 1] == nums[j])
					continue;


				int l = i + 1;
				int r = j - 1;

				// i < l < r <j
				while (l < r) {

					int sum = nums[i] + nums[l] + nums[r] + nums[j];
					if (sum == target) {
						ans.add(Arrays.asList(nums[i], nums[l], nums[r], nums[j]));

						// to avoid duplicates; for the same numbers in sorted array
						while (l + 1 < r && nums[l + 1] == nums[l])
							l++;
						while (l < r - 1 && nums[r - 1] == nums[r])
							r--;

						// the next element after the same elements in sorted array
						l++;
						r--;
					} else if (sum > target) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		return ans;

  }

}