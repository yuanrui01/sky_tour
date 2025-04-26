package org.hypnos;

/**
 * ???
 * 2444. 统计定界子数组的数目
 */
public class CountSubarrays {

	public long countSubarrays(int[] nums, int minK, int maxK) {
		long ans = 0;
		int minI = -1, maxI = -1, i0 = -1;
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (x == minK) {
				minI = i; // 最近的 minK 位置
			}
			if (x == maxK) {
				maxI = i; // 最近的 maxK 位置
			}
			if (x < minK || x > maxK) {
				i0 = i; // 子数组不能包含 nums[i0]
			}
			ans += Math.max(Math.min(minI, maxI) - i0, 0);
		}
		return ans;
	}
}
