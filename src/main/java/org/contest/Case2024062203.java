package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024062203 {

	public int minOperations(int[] nums) {
		int count = 0;
		boolean isFlipped = false;
		for (int num : nums) {
			if ((num == 0 && !isFlipped) || (num == 1 && isFlipped)) {
				count++;
				isFlipped = !isFlipped;
			}
		}
		return count;
	}


	public static void main(String[] args) {
		Case2024062203 case2024062203 = new Case2024062203();
		int[] nums = {1,0,0,0};

		System.out.println(case2024062203.minOperations(nums));
	}
}
