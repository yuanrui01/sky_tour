package org.hypnos;

/**
 * 922. 按奇偶排序数组 II
 */
public class SortArrayByParityII {

	public int[] sortArrayByParityII(int[] nums) {
		int n = nums.length;
		int[] sn = new int[n];
		int odd = 1;
		int even = 0;
		for (int num : nums) {
			if ((num&1) == 1) {
				sn[odd] = num;
				odd+=2;
			} else {
				sn[even] = num;
				even+=2;
			}
		}
		return sn;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		int[] nums = {648,831,560,986,192,424,997,829,897,843};
		SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
		System.out.println(sortArrayByParityII.sortArrayByParityII(nums));
	}
}
