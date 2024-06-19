package org.ds;

/**
 * 1512. 好数对的数目
 */
public class NumIdenticalPairs {

	public int numIdenticalPairs(int[] nums) {
		int ans = 0;
		int[] map = new int[101];
		for (int i = 0; i < nums.length; ++i) {
			ans += map[nums[i]];
			map[nums[i]]++;
		}
		return ans;
	}
}
