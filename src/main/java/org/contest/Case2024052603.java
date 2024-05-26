package org.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class Case2024052603 {

	public long numberOfPairs(int[] nums1, int[] nums2, int k) {
		for (int i = 0; i < nums2.length; i++)
			nums2[i] = nums2[i] * k;
		Map<Integer, Integer> divisorsMap = new HashMap<>();
		for (int num : nums2)
			divisorsMap.merge(num, 1, Integer::sum);
		long ans = 0;
		for (int num1 : nums1) {
			for (int i = 1; i <= Math.sqrt(num1); i++) {
				if (num1 % i == 0) {
					ans += divisorsMap.getOrDefault(i, 0);
					int i2 = num1 / i;
					if (i2 != i && num1 % i2 == 0) {
						ans += divisorsMap.getOrDefault(i2, 0);
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums1 ={1,2,4,12};
		int[] nums2 ={2,4};
		int k = 3;
	}
}
