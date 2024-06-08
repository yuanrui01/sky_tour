package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 3040. 相同分数的最大操作数目 II
 */
public class MaxOperations {

	public int maxOperations(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		Map<String,Integer> cache = new HashMap<>();

		int res1 =  dp(nums, cache,left + 1, right - 1, nums[left] + nums[right]);
		int res2 = dp(nums, cache,left + 2, right, nums[left] + nums[left + 1]);
		int res3 = dp(nums, cache,left, right - 2, nums[right - 1] + nums[right]);
		return Math.max(res3, Math.max(res1, res2)) + 1;
	}

	private int dp(int[] nums, Map<String,Integer> cache, int left, int right, int target) {
		if (left >= right)
			return 0;
		String cacheKey = left + "," + right + "," + target;
		if (cache.get(cacheKey) != null)
			return cache.get(cacheKey);
		int res1 = 0;
		if (target == nums[left] + nums[right]) {
			res1 = dp(nums, cache, left + 1, right - 1, target) + 1;
		}
		int res2 = 0;
		if (target == nums[left] + nums[left + 1]) {
			res2 = dp(nums, cache, left + 2, right, nums[left] + nums[left + 1]) + 1;
		}
		int res3 = 0;
		if (target == nums[right - 1] + nums[right]) {
			res3 = dp(nums, cache,  left, right - 2, nums[right - 1] + nums[right]) + 1;
		}
		int res = Math.max(res3, Math.max(res1, res2));
		cache.put(cacheKey, res);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {3,2,1,2,3,4};
		MaxOperations maxOperations = new MaxOperations();
		System.out.println(maxOperations.maxOperations(nums));
	}
}
