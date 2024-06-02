package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 1695. 删除子数组的最大得分
 */
public class MaximumUniqueSubarray {

	public int maximumUniqueSubarray(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		int[] preSum = new int[n];
		preSum[0] = nums[0];
		for (int i = 1; i < n; ++i) {
			preSum[i] = preSum[i - 1] + nums[i];
		}

		int left = 0;
		int right = 0;
		int ans = 0;

		while (right < n) {
			map.put(nums[right], right);
			while (right + 1 < n && map.getOrDefault(nums[right + 1], - 1) < left) {
				right++;
				map.put(nums[right], right);
			}
			ans = Math.max(ans, preSum[right] - preSum[left] + nums[left]);
			if (right + 1 < n)
				left =  Math.max(left, map.getOrDefault(nums[right + 1], -1) + 1);
			right++;
		}

		return  ans;
	}

	public static void main(String[] args) {
		int[] nums = {5,2,1,2,5,2,1,2,5};

		MaximumUniqueSubarray maximumUniqueSubarray = new MaximumUniqueSubarray();
		System.out.println(maximumUniqueSubarray.maximumUniqueSubarray(nums));
	}
}
