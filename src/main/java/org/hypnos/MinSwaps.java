package org.hypnos;

/**
 * 2134. 最少交换次数来组合所有的 1 II
 */
public class MinSwaps {

	public int minSwaps(int[] nums) {
		int window = 0;
		for (int num : nums)
			if (num == 1)
				window++;
		int length = nums.length;
		if (window == length)
			return 0;
		int tOneCount = 0;
		for (int i = 0; i < window; ++i)
			if (nums[i] == 1)
				tOneCount++;
		int maxOneCount = tOneCount;
		for (int k = 0; k < length - 1; ++k) {
			if (nums[(k + window) % length] == 1)
				tOneCount++;
			if (nums[k % length] == 1)
				tOneCount--;
			maxOneCount = Math.max(maxOneCount, tOneCount);
		}
		return window - maxOneCount;
	}

}
