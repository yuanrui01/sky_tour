package org.hypnos;

import java.util.Arrays;

/**
 * 2563. 统计公平数对的数目
 */
public class CountFairPairs {

	public long countFairPairs(int[] nums, int lower, int upper) {
		long ans = 0L;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			int r = lowerBound(nums, i - 1, upper - nums[i] + 1);
			int l = lowerBound(nums, i - 1, lower - nums[i]);
			ans += r - l;
		}
		return ans;
	}

	private int lowerBound(int[] nums, int right, int target) {
		int left = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		CountFairPairs countFairPairs = new CountFairPairs();
		int[] nums = {1, 2, 3, 3, 3, 4, 5};
		System.out.println(countFairPairs.lowerBound(nums, 6, 6));
	}
}
