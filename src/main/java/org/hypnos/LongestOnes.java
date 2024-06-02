package org.hypnos;

import java.util.ArrayDeque;

/**
 * 1004. 最大连续1的个数 III
 */
public class LongestOnes {

	public int longestOnes(int[] nums, int k) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int n = nums.length;
		int ans = 0;
		int left = 0;
		int right = 0;
		while (right < n) {
			int num = nums[right];
			if (num == 0) {
				if (k == 0) {
					left = right + 1;
					right++;
					continue;
				}
				queue.offer(right);
			}
			while (right + 1 < n && queue.size() <= k) {
				if (nums[right + 1] == 0) {
					if (queue.size() == k)
						break;
					else
						queue.offer(right + 1);
				}
				right++;
			}
			ans = Math.max(ans, right - left + 1);
			if (!queue.isEmpty())
				left = Math.max(left, queue.poll() + 1);
			if (k == 0)
				left = left + 1;
			right++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1};
		int k = 0;
		LongestOnes longestOnes = new LongestOnes();
		System.out.println(longestOnes.longestOnes(nums, k));
	}


	public int longestOnes2(int[] nums, int k) {
		int left = 0, right = 0;
		int zeros = 0;  // 记录窗口内0的个数
		int ans = 0;
		while (right < nums.length) {
			if (nums[right] == 0)
				zeros++;
			while (zeros > k) {
				if (nums[left] == 0)
					zeros--;
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}
}
