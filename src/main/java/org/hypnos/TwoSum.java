package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class TwoSum {


	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			int x = nums[i];
			if (map.containsKey(target - x)) {
				return new int[]{i, map.get(target - x)};
			}
			map.put(x, i);
		}
		return new int[]{};
	}
}
