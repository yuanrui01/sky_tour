package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. 统计坏数对的数目
 */
public class CountBadPairs {

	public long countBadPairs(int[] nums) {
		long n = nums.length;
		Map<Integer, Long> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			map.merge(nums[i] - i, 1L, Long::sum);
		}
		long goodCount = 0;
		for (Long dup : map.values()) {
			goodCount += dup * (dup - 1) / 2;
		}
		return n * (n - 1) / 2 - goodCount;
	}
}
