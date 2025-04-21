package org.hypnos;

/**
 * 2176. 统计数组中相等且可以被整除的数对
 */
public class CountPairs2176 {

	public int countPairs(int[] nums, int k) {
		int ans = 0;
		int n = nums.length;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (nums[i] == nums[j] && (i * j) % k == 0) ans++;
			}
		}
		return ans;
	}
}
