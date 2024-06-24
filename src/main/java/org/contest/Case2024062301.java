package org.contest;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class Case2024062301 {

	public double minimumAverage(int[] nums) {
		Arrays.sort(nums);

		int n = nums.length;
		double ans = Double.MAX_VALUE;
		for (int i = 0; i < n / 2; ++i) {
			ans = Math.min(ans, (nums[i] + nums[n - i - 1])/2.0);
		}

		return ans;
	}


	public static void main(String[] args) {
		Case2024062301 case2024062301 = new Case2024062301();
	}
}
