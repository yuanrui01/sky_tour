package org.hypnos;

import java.util.Arrays;

/**
 * 2389. 和有限的最长子序列
 */
public class AnswerQueries {

	public int[] answerQueries(int[] nums, int[] queries) {
		Arrays.sort(nums);
		int[] preSum = new int[nums.length];
		preSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			ans[i] = find(preSum, queries[i]);
		}
		return ans;
	}

	private int find(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nums = {4,5,2,1};
		int[] queries = {3,10,21};

		int[] ints = new AnswerQueries().answerQueries(nums, queries);
		System.out.println(Arrays.toString(ints));
	}
}
