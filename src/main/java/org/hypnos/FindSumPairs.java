package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 1865. 找出和为指定值的下标对
 */
public class FindSumPairs {

	private final int[] nums1;
	private final int[] nums2;
	private final Map<Integer, Integer> cnt = new HashMap<>();

	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums1 = nums1;
		this.nums2 = nums2;
		for (int x : nums2) {
			cnt.merge(x, 1, Integer::sum);
		}
	}

	public void add(int index, int val) {
		// 维护 nums2 每个元素的出现次数
		cnt.merge(nums2[index], -1, Integer::sum);
		nums2[index] += val;
		cnt.merge(nums2[index], 1, Integer::sum);
	}

	public int count(int tot) {
		int ans = 0;
		for (int x : nums1) {
			ans += cnt.getOrDefault(tot - x, 0);
		}
		return ans;
	}
}
