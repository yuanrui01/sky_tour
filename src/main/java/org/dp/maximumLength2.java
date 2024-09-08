package org.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 3177. 求出最长好子序列 II
 */
public class maximumLength2 {

	public int maximumLength(int[] nums, int k) {
		Map<Integer, int[]> fs = new HashMap<>();
		int[] mx = new int[k + 2];
		for (int x : nums) {
			int[] f = fs.computeIfAbsent(x, i -> new int[k + 1]);
			for (int j = k; j >= 0; j--) {
				f[j] = Math.max(f[j], mx[j]) + 1;
				mx[j + 1] = Math.max(mx[j + 1], f[j]);
			}
		}
		return mx[k + 1];
	}
}
