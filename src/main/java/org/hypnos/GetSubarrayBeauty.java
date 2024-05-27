package org.hypnos;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 2653. 滑动子数组的美丽值
 */
public class GetSubarrayBeauty {
	public int[] getSubarrayBeauty(int[] nums, int k, int x) {
		int len = nums.length;
		int[] result = new int[len - k + 1];
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < k; ++i) {
			if (set.size() != x)
				set.add(nums[i]);
			else if (nums[i] < set.last()) {
				set.pollLast();
				set.add(nums[i]);
			}
		}
		if (set.last() < 0)
			result[0] = set.last();

		for (int i = k; i < len; ++i) {
			set.remove(nums[i - k]);
			if (set.size() != x)
				set.add(nums[i]);
			else if (nums[i] < set.last()) {
				set.pollLast();
				set.add(nums[i]);
			}
			set.
			if (set.last() < 0)
				result[i - k + 1] = set.last();
		}
		return result;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{-30,-17,23,35};
		int k = 3;
		int x = 1;

		int[] subarrayBeauty = new GetSubarrayBeauty().getSubarrayBeauty(nums, k, x);
		System.out.println(Arrays.toString(subarrayBeauty));
	}
}
