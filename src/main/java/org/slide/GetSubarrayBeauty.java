package org.slide;

/**
 * 2653. 滑动子数组的美丽值
 * @author: yuanrui
 */
public class GetSubarrayBeauty {

	private int bias = 50;

	public int[] getSubarrayBeauty(int[] nums, int k, int x) {
		int n = nums.length;
		int[] cnt = new int[2 * bias + 1];
		int[] ans = new int[n - k + 1];
		for (int i = 0; i < k; ++i) {
			cnt[nums[i] + bias]++;
		}
		ans[0] = getXMin(cnt, x);
		for (int i = k; i < n; ++i) {
			cnt[nums[i] + bias]++;
			cnt[nums[i - k] + bias]--;
			ans[i - k + 1] = getXMin(cnt, x);
		}
		return ans;
	}

	private int getXMin(int[] cnt, int x) {
		int left = x;
		for (int i = 0; i < bias; ++i) {
			left -= cnt[i];
			if (left <= 0) {
				return i - bias;
			}
		}
		return 0;
	}
}
