package org.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 */
public class FourSumCount {

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		int ans = 0;
		for (int i : nums1)
			for (int j : nums2)
				map1.merge(i + j, 1, Integer::sum);
		for (int i : nums3)
			for (int j : nums4)
				map2.merge(i + j, 1, Integer::sum);
		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			if (map2.get(-key) != null) {
				ans += value * map2.get(-key);
			}
		}
		return ans;
	}
}
