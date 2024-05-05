package org.hypnos;

/**
 * LIS 二分解法
 */
public class LengthOfLIS2 {

	public int lengthOfLIS(int[] nums) {
		int ng = 0; // g 的长度
		for (int x : nums) {
			int j = lowerBound(nums, ng, x);
			nums[j] = x;
			if (j == ng) { // >=x 的 g[j] 不存在
				ng++;
			}
		}
		return ng;
	}

	// 开区间写法
	private int lowerBound(int[] nums, int right, int target) {
		int left = -1; // 开区间 (left, right)
		while (left + 1 < right) { // 区间不为空
			// 循环不变量：
			// nums[left] < target
			// nums[right] >= target
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid; // 范围缩小到 (mid, right)
			} else {
				right = mid; // 范围缩小到 (left, mid)
			}
		}
		return right; // 或者 left+1
	}
}
