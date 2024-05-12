package org.hypnos;


/**
 * 410. 分割数组的最大值
 */
public class SplitArray {

	public int splitArray(int[] nums, int k) {
		int sum = 0;
		int mx = 0;
		for (int x : nums) {
			sum += x;
			mx = Math.max(mx, x);
		}

		int left = Math.max(mx, (sum) / k);
		int right = sum;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (check(nums, k, mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean check(int[] nums, int k, int mx) {
		int cnt = 1;
		int s = 0;
		for (int x : nums) {
			if (s + x <= mx) {
				s += x;
			} else { // 新划分一段
				if (cnt == k) {
					return false;
				}
				cnt += 1;
				s = x;
			}
		}
		return true;
	}


	public static void main(String[] args) {

		SplitArray splitArray = new SplitArray();
		int[] nums = {1, 4, 4};
		int k = 3;
		System.out.println(splitArray.splitArray(nums, k));
	}
}
