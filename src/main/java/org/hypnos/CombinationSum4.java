package org.hypnos;

import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ - 记忆化搜索
 **/
class CombinationSum4 {

	public int combinationSum4(int[] nums, int target) {
		int[] cache = new int[1001];
		Arrays.fill(cache, -1);
		return dp(nums, cache, target);
	}

	private int dp(int[] nums, int[] cache, int target) {
		if (target == 0)
			return 1;
		if (cache[target] != -1)
			return cache[target];
		int ans = 0;
		for (int num : nums)
			if (num <= target)
				ans += dp(nums, cache, target - num);
		return cache[target] = ans;
	}
}