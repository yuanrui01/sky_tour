package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. 最多 K 个重复元素的最长子数组
 */
public class MaxSubarrayLength {

	public int maxSubarrayLength(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		int left = 0;
		for (int i = 0; i < nums.length; ++i) {
			map.merge(nums[i], 1, Integer::sum);
			while (map.get(nums[i]) > k)
				map.merge(nums[left++], -1, Integer::sum);
			ans = Math.max(ans, i - left + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,1,2,3,1,2};
		int k = 2;
		MaxSubarrayLength maxSubarrayLength = new MaxSubarrayLength();
		System.out.println(maxSubarrayLength.maxSubarrayLength(nums, k));
	}
}
