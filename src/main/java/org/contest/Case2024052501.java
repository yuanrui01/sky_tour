package org.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class Case2024052501 {

	public int duplicateNumbersXOR(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.merge(nums[i], 1, Integer::sum);
		}
		int ans = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				ans ^= entry.getKey();
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] nums = {1,2,3};

		int i = new Case2024052501().duplicateNumbersXOR(nums);
		System.out.println(i);
	}

}
