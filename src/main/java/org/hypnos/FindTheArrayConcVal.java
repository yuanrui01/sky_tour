package org.hypnos;

/**
 * 2562. 找出数组的串联值
 */
public class FindTheArrayConcVal {

	public long findTheArrayConcVal(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		long ans = 0L;
		while (left <= right) {
			if (left == right) {
				ans += nums[left];
			} else {
				int c = 1;
				int rV = nums[right];
				while (rV != 0) {
					c *= 10;
					rV /= 10;
				}
				ans += (long) (nums[left]) * c + nums[right];
			}
			left++;
			right--;
		}
		return ans;
	}
}
