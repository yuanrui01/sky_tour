package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * ???
 * 2537. 统计好子数组的数目
 */
public class CountGood {

	public long countGood(int[] nums, int k) {
		long ans = 0;
		Map<Integer, Integer> cnt = new HashMap<>();
		int pairs = 0;
		int left = 0;
		for (int x : nums) {
			int c = cnt.getOrDefault(x, 0);
			pairs += c; // 进
			cnt.put(x, c + 1);
			while (pairs >= k) {
				x = nums[left];
				c = cnt.get(x);
				pairs -= c - 1; // 出
				cnt.put(x, c - 1);
				left++;
			}
			ans += left;
		}
		return ans;
	}
}
