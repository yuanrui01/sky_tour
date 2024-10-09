package org.hypnos;

/**
 * 100315. 找到按位与最接近 K 的子数组
 */
public class MinimumDifference {

	public int minimumDifference(int[] nums, int k) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; ++i) {
			int x = nums[i];
			ans = Math.min(ans, Math.abs(x - k));
			for (int j = i - 1; j >= 0 && (nums[j] & x) != nums[j] ; --j) {
				nums[j] &= x;
				ans = Math.min(ans, Math.abs(nums[j] - k));
			}
		}
		return ans;
	}

	public int miniumDifference(int[] nums, int k) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			ans = Math.min(ans, Math.abs(x - k));
			for (int j = i - 1; j >= 0; j--) {
				nums[j] |= x;
				ans = Math.min(ans, Math.abs(nums[j] - k));
			}
		}
		return ans;
	}
}
