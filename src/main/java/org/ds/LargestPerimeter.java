package org.ds;

import java.util.Arrays;

/**
 * 2971. 找到最大周长的多边形
 */
public class LargestPerimeter {

	public long largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		long sum = 0;
		for (int num : nums)
			sum += num;
		for(int i = len - 1; i >= 0; --i) {
			if (nums[i] < sum - nums[i])
				return sum;
			sum -= nums[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {1,12,1,2,5,50,3};
		LargestPerimeter largestPerimeter = new LargestPerimeter();
		long l = largestPerimeter.largestPerimeter(nums);
		System.out.println(l);
	}
}
