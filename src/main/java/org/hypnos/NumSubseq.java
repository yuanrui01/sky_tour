package org.hypnos;

import java.util.Arrays;

/**
 * 1498. 满足条件的子序列数目
 */
public class NumSubseq {

	public int numSubseq(int[] nums, int target) {
		int MODULO = 1000000007;
		int subsequences = 0;
		int length = nums.length;
		int[] power2 = new int[length];
		power2[0] = 1;
		for (int i = 1; i < length; i++) {
			power2[i] = power2[i - 1] * 2 % MODULO;
		}
		Arrays.sort(nums);
		int left = 0, right = length - 1;
		while (left <= right && nums[left] * 2 <= target) {
			while (nums[left] + nums[right] > target) {
				right--;
			}
			int count = power2[right - left];
			subsequences = (subsequences + count) % MODULO;
			left++;
		}
		return subsequences;
	}
}
