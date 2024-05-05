package org.hypnos;

/**
 * 300. 最长递增子序列
 */
public class LengthOfLIS {

	private int[] nums, memo;

	public int lengthOfLIS(int[] nums) {
		this.nums = nums;
		int n = nums.length;
		memo = new int[n]; // 本题可以初始化成 0，表示没有计算过
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dfs(i));
		}
		return ans;
	}

	private int dfs(int i) {
		if (memo[i] > 0) { // 之前计算过
			return memo[i];
		}
		for (int j = 0; j < i; j++) {
			if (nums[j] < nums[i]) {
				memo[i] = Math.max(memo[i], dfs(j));
			}
		}
		return ++memo[i];
	}
}
