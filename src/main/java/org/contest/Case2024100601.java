package org.contest;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class Case2024100601 {

	public int maxGoodNumber(int[] nums) {
		String[] sr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sr[i] = Integer.toBinaryString(nums[i]);
		}
		Arrays.sort(sr, (a, b) -> (b + a).compareTo(a + b));
		StringBuilder sb = new StringBuilder();
		for (String binary : sr) {
			sb.append(binary);
		}
		return Integer.parseInt(sb.toString(), 2);
	}


	public static void main(String[] args) {

	}
}
