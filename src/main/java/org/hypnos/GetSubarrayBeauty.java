package org.hypnos;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 2653. 滑动子数组的美丽值 - 滑动窗口 + 暴力枚举
 */
public class GetSubarrayBeauty {


	public int[] getSubarrayBeauty(int[] nums, int k, int x) {
		int len = nums.length;
		int[] ans = new int[len - k + 1];
		int[] forces = new int[101];

		for (int i = 0; i < k; ++i) {
			forces[nums[i] + 50]++;
		}
		for (int i = 0, ix = 0; i < 50; ++i) {
			if (forces[i] > 0) {
				ix += forces[i];
				if (ix >= x) {
					ans[0] = i - 50;
					break;
				}
			}
		}

		for (int i = k; i < nums.length; ++i) {
			forces[nums[i] + 50]++;
			forces[nums[i - k] + 50]--;
			for (int j = 0, ij = 0; j < 50; ++j) {
				if (forces[j] > 0) {
					ij += forces[j];
					if (ij >= x) {
						ans[i - k + 1] = j - 50;
						break;
					}
				}
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{1,-1,-3,-2,3};
		int k = 3;
		int x = 2;

		int[] subarrayBeauty = new GetSubarrayBeauty().getSubarrayBeauty(nums, k, x);
		System.out.println(Arrays.toString(subarrayBeauty));
	}
}
