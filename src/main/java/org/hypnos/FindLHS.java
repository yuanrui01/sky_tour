package org.hypnos;

import java.util.Arrays;

/**
 * 594. 最长和谐子序列
 */
public class FindLHS {

	public int findLHS(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		if (n == 1 || nums[0] == nums[n-1]) return 0;
		int ans = 0;
		int left = 0;
		int right = 1;
		while (left < nums.length) {
			while (right < nums.length && nums[right] - nums[left] <= 1) {
				right++;
			}
			if (nums[left] != nums[right-1]) {
				ans = Math.max(ans, right - left);
			}
			left++;
			right = Math.max(right, left+1);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1,4,1,3,1,-14,1,-13};
		FindLHS findLHS = new FindLHS();
		System.out.println(findLHS.findLHS(nums));
	}
}
