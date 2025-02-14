package org.hypnos;

/**
 * 922. 按奇偶排序数组 II
 */
public class SortArrayByParityII {

	public int[] sortArrayByParityII(int[] nums) {
		int even = 0;
		int odd = 1;
		while (even < nums.length) {
			if ((nums[even]&1) == 1) {
				while ((nums[odd]&1) == 1) {
					odd+=2;
				}
				swap(nums, even, odd);
			}
			even+=2;
		}
		return nums;
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
