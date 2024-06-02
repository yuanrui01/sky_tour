package org.hypnos;

import java.util.List;

/**
 * @author: yuanrui
 */
public class LongestSubarray {

	public int longestSubarray(int[] nums) {
		int ans = 0, mx = 0, cnt = 0;
		for (int x : nums) {
			if (x > mx) {
				mx = x;
				ans = cnt = 1;
			} else if (x == mx) {
				cnt++;
				if (cnt > ans) {
					ans = cnt;
				}
			} else {
				cnt = 0;
			}
		}
		return ans;
	}
}
