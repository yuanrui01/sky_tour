package org.hypnos;

/**
 * 3392. 统计符合条件长度为 3 的子数组数目
 */
public class CountSubarrays3392 {

	public int countSubarrays(int[] nums) {
		int n = nums.length;
		int i = 0;
		int j = 1;
		int k = 2;
		int ans = 0;
		while (k < n) if (2 * (nums[i++] + nums[k++]) == nums[j++]) ans++;
		return ans;
	}
}
