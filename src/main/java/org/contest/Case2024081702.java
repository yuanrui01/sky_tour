package org.contest;

import java.util.Arrays;

/**
 * 100384. 长度为 K 的子数组的能量值 II
 */
public class Case2024081702 {

	public int[] resultsArray(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n - k + 1];
		int[] preSum = new int[n];
		for (int i = 1; i < n; ++i) {
			preSum[i] = nums[i - 1] + 1 != nums[i] ? preSum[i - 1] + 1: preSum[i - 1];
		}

		for (int i = 0; i < n - k + 1; ++i) {
			if (preSum[i + k - 1] - preSum[i] == 0) {
				ans[i] = nums[i + k - 1];
			} else {
				ans[i] = -1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Case2024081702 case2024081702 = new Case2024081702();

		int[] nums = {1,7,8};
		int k = 2;
		System.out.println(Arrays.toString(case2024081702.resultsArray(nums,k)));
	}
}
