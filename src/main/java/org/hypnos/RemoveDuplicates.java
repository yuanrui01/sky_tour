package org.hypnos;

/**
 * 80. 删除有序数组中的重复项 II
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int i1 = 0;
		int i2 = 0;
		int n = nums.length;
		while (i1 < n) {
			int num = nums[i1];
			int cnt = 1;
			while (i1 + 1 < n && nums[i1 + 1] == num) {
				i1++;
				cnt++;
			}
			int inc2 = Math.min(2, cnt);
			for (int i = 1; i <= inc2; ++i) {
				nums[i2++] = num;
			}
			i1++;
		}
		return i2;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		System.out.println(removeDuplicates.removeDuplicates(nums));
	}
}
