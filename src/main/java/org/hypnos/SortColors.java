package org.hypnos;

/**
 * 75. 颜色分类
 */
public class SortColors {

	public void sortColors(int[] nums) {
		int p0 = 0;
		int p1 = 0;
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			nums[i] = 2;
			if (x <= 1) {
				nums[p1++] = 1;
			}
			if (x == 0) {
				nums[p0++] = 0;
			}
		}
	}


	public static void main(String[] args) {
		SortColors sortColors = new SortColors();
		int[] nums = {1,2,0};
		sortColors.sortColors(nums);
	}
}
