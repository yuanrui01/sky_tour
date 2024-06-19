package org.ds;

/**
 * 2815. 数组中的最大数对和
 */
public class MaxSum {

	public int maxSum(int[] nums) {
		int[] hash = new int[10];
		int ans = -1;
		for(int i = 0; i < nums.length; ++i) {
			int d = getMaxDigit(nums[i]);
			if (hash[d] > 0) {
				ans = Math.max(ans, nums[i] + hash[d]);
			}
			hash[d] = Math.max(hash[d], nums[i]);
		}
		return ans;
	}

	private int getMaxDigit(int n) {
		int ans = 0;
		while (n > 0) {
			ans = Math.max(ans, n % 10);
			n = n / 10;
		}
		return ans;
	}
}
