package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024062201 {

	public int minimumOperations(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			int i = num % 3;
			if (i != 0)
				ans++;
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		Case2024062201 case2024062201 = new Case2024062201();
		System.out.println(case2024062201.minimumOperations(nums));
	}
}
