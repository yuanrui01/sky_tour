package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 3132. 找出与数组相加的整数 II
 */
public class MinimumAddedInteger {

	public int minimumAddedInteger(int[] nums1, int[] nums2) {
		int max1 = -1;
		for (int i1 : nums1) {
			max1 = Math.max(max1, i1);
		}
		Map<Integer, Integer> map1 = new HashMap<>();
		int[] map2 = new int[2001];
		int min2 = 1001;
		for (int i2 : nums2) {
			map2[i2 + 1000]++;
			min2 = Math.min(min2, i2);
		}
		for (int i = min2 - max1; i <= 1000; ++i) {
			map1.clear();
			for (int i1 : nums1) {
				map1.merge(i1 + i, 1, Integer::sum);
			}
			if (checkMap(map1, map2))
				return i;
		}
		return -1;
	}

	// 输入：nums1 = [3,5,5,3], nums2 = [7,7]
	private boolean checkMap(Map<Integer, Integer> map1, int[] map2) {
		int diff = 0;
		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			diff += Math.abs(value - map2[key + 1000]);
		}
		return diff <= 2;
	}


	public static void main(String[] args) {
		int[] nums1 = {4,20,16,12,8};
		int[] nums2 = {14,18,10};
		MinimumAddedInteger minimumAddedInteger = new MinimumAddedInteger();
		System.out.println(minimumAddedInteger.minimumAddedInteger(nums1, nums2));
	}
}
