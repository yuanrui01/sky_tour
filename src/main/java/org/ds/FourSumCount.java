package org.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 */
public class FourSumCount {

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map1 = new HashMap<>();
		int ans = 0;
		for (int i : nums1)
			for (int j : nums2)
				map1.merge(i + j, 1, Integer::sum);
		for (int i : nums3)
			for (int j : nums4) {
				Integer count = map1.get(-(i + j));
				if (count != null)
					ans += count;
			}
		return ans;
	}
}
