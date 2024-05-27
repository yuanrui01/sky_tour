package org.hypnos;

/**
 * 2134. 最少交换次数来组合所有的 1 II
 */
public class MinSwaps {

	public int minSwaps(int[] nums) {
		int oneCount = 0;
		for (int num : nums) {
			if (num == 1)
				oneCount++;
		}
		int length = nums.length;
		if (oneCount == length)
			return 0;

		int tOneCount = 0;
		int window = oneCount;
		for (int i = 0; i < window; ++i) {
			if (nums[i] == 1)
				tOneCount++;
		}
		int maxOneCount = tOneCount;
		for (int k = 0; k < length - 1; ++k) {
			if (nums[(k + length + window) % length] == 1)
				tOneCount++;
			if (nums[(k + length) % length] == 1)
				tOneCount--;
			maxOneCount = Math.max(maxOneCount, tOneCount);
		}
		return oneCount - maxOneCount;
	}

}
