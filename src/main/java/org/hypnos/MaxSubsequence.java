package org.hypnos;

import java.util.*;

/**
 * 2099. 找到和最大的长度为 K 的子序列
 */
public class MaxSubsequence {

	public int[] maxSubsequence(int[] nums, int k) {
		int n = nums.length;
		int[] tmp = new int[n];
		System.arraycopy(nums, 0, tmp, 0, n);
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = n - k; i < n; ++i) {
			map.merge(nums[i], 1, Integer::sum);
		}
		int[] ans = new int[k];
		int i = 0;
		int j = 0;
		while (i < k) {
			Integer count = map.get(tmp[j]);
			if (count != null && count > 0) {
				ans[i++] = tmp[j];
				map.put(tmp[j], count-1);
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {-16,-13,8,16,35,-17,30,-8,34,-2,-29,-35,15,13,-30,-34,6,15,28,-23,34,28,-24,15,-17,10,31,32,-3,-36,19,31,-5,-21,-33,-18,-23,-37,-15,12,-28,-40,1,38,38,-38,33,-35,-28,-40,4,-15,-29,-33,-18,-9,-29,20,1,36,-8,23,-34,16,-7,13,39,38,7,-7,-10,30,9,26,27,-37,-18,-25,14,-36,23,28,-15,35,-9,1};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
