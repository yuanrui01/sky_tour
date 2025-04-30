package org.hypnos;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 */
public class CountSubarrays2962 {

	public long countSubarrays(int[] nums, int k) {
		int mx = 0;
		for (int num : nums) {
			mx = Math.max(mx, num);
		}
		long ans = 0;
		int n = nums.length;
		int left = 0;
		int right = 0;
		int mxCnt = 0;
		while (right < n) {
			mxCnt += nums[right] == mx ? 1 : 0;
			int inc = n - right;
			while (mxCnt >= k) {
				ans += inc;
				mxCnt -= nums[left] == mx ? 1 : 0;
				left++;
			}
			right++;
		}
		return ans;
	}
}
