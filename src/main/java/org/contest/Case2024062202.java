package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024062202 {

	public int minOperations(int[] nums) {
		int count = 0;
		int n = nums.length;
		for (int i = 0; i <= n - 3; i++) {
			if (nums[i] == 0) {
				for (int j = i; j < i + 3; j++)
					nums[j] = nums[j] == 0 ? 1 : 0;
				count++;
			}
		}
		for (int i = n - 2; i < n; i++)
			if (nums[i] == 0)
				return -1;
		return count;
	}


	public static void main(String[] args) {
		Case2024062202 case2024062202 = new Case2024062202();
		int[] nums = {0,1,1,1};

		System.out.println(case2024062202.minOperations(nums));

	}
}
