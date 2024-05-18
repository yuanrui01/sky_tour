package org.hypnos;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {

	public int maxProduct(int[] nums) {
		int maxF = nums[0], minF = nums[0], ans = nums[0];
		int length = nums.length;
		for (int i = 1; i < length; ++i) {
			int mx = maxF, mn = minF;
			maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
			minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
			ans = Math.max(maxF, ans);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {-2,0,-1};
		MaxProduct mp = new MaxProduct();
		System.out.println(mp.maxProduct(nums));
	}
}
