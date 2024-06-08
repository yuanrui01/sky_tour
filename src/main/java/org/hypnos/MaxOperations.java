package org.hypnos;

import java.util.Arrays;

/**
 * 3040. 相同分数的最大操作数目 II
 */
public class MaxOperations {

	public int maxOperations(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		int res1 =  helper(nums,left + 1, right - 1, nums[left] + nums[right]);
		int res2 = helper(nums,left + 2, right, nums[left] + nums[left + 1]);
		int res3 = helper(nums,left, right - 2, nums[right - 1] + nums[right]);
		return Math.max(res3, Math.max(res1, res2)) + 1;
	}

	private int helper(int[] nums, int left, int right, int target) {
		int n = nums.length;
		int[][] memo = new int[n][n];
		for (int[] ints : memo) {
			Arrays.fill(ints, -1);
		}
		return dp(nums, memo, left, right, target);
	}

	private int dp(int[] nums, int[][] memo, int left, int right, int target) {
		if (left >= right)
			return 0;
		if (memo[left][right] != -1)
			return memo[left][right];
		int res1 = 0;
		if (target == nums[left] + nums[right]) {
			res1 = dp(nums, memo, left + 1, right - 1, target) + 1;
		}
		int res2 = 0;
		if (target == nums[left] + nums[left + 1]) {
			res2 = dp(nums, memo, left + 2, right, nums[left] + nums[left + 1]) + 1;
		}
		int res3 = 0;
		if (target == nums[right - 1] + nums[right]) {
			res3 = dp(nums, memo,  left, right - 2, nums[right - 1] + nums[right]) + 1;
		}
		int res = Math.max(res3, Math.max(res1, res2));
		memo[left][right] = res;
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {3,2,1,2,3,4};
		MaxOperations maxOperations = new MaxOperations();
		System.out.println(maxOperations.maxOperations(nums));
	}
}
