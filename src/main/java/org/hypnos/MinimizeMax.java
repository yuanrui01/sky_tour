package org.hypnos;

import java.util.Arrays;

/**
 * 2616. 最小化数对的最大差值
 */
public class MinimizeMax {

	public int minimizeMax(int[] nums, int p) {
		Arrays.sort(nums);
		int left = -1;
		int right = nums[nums.length - 1] - nums[0];
		while (left + 1 < right) {
			int mid = (left + right) >>> 1;
			if (check(mid, nums, p)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}

	private boolean check(int mx, int[] nums, int p) {
		int cnt = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] - nums[i] <= mx) { // 选 nums[i] 和 nums[i+1]
				cnt++;
				i++;
			}
		}
		return cnt >= p;
	}
}
