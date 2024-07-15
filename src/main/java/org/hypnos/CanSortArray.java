package org.hypnos;

/**
 * 3011. 判断一个数组是否可以变为有序
 */
public class CanSortArray {

	public boolean canSortArray(int[] nums) {
		int n = nums.length;
		int idx = 0;
		int preMax = Integer.MIN_VALUE;
		while (idx < n) {
			int digitCount = Integer.bitCount(nums[idx]);
			int segMax = nums[idx];
			int segMin = nums[idx];
			while (idx + 1 < n && Integer.bitCount(nums[idx + 1]) == digitCount) {
				idx++;
				segMax = Math.max(segMax, nums[idx]);
				segMin = Math.min(segMin, nums[idx]);
			}
			if (preMax > segMin) return false;
			preMax = Math.max(preMax, segMax);
			idx++;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {35,143,127,254};
		CanSortArray canSortArray = new CanSortArray();
		System.out.println(canSortArray.canSortArray(nums));
	}
}
