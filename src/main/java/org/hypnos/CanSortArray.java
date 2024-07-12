package org.hypnos;

/**
 * 3011. 判断一个数组是否可以变为有序
 */
public class CanSortArray {

	public boolean canSortArray(int[] nums) {
		int n = nums.length;
		int idx = 0;
		int pre = Integer.bitCount(nums[0]);
		int max = nums[0];
		int min = nums[0];
		int preMax = Integer.MIN_VALUE;
		while (idx < n) {
			while (idx + 1 < n &&  Integer.bitCount(nums[idx + 1]) == pre) {
				idx++;
				max = Math.max(max, nums[idx]);
				min = Math.min(min, nums[idx]);
				pre = Integer.bitCount(nums[idx]);
			}
			if (preMax > min)
				return false;
			idx++;
			if (idx < n) {
				preMax = max;
				pre = Integer.bitCount(nums[idx]);
				max = nums[idx];
				min = nums[idx];
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {20, 16};
		CanSortArray canSortArray = new CanSortArray();
		System.out.println(canSortArray.canSortArray(nums));
	}
}
