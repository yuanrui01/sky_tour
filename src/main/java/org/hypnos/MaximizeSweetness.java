package org.hypnos;

/**
 * 1231. 分享巧克力
 */
public class MaximizeSweetness {


	public int maximizeSweetness(int[] sweetness, int k) {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int x : sweetness) {
			sum += x;
			min = Math.min(min, x);
		}

		k++;
		int left = min;
		int right = sum;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (check(sweetness, k, mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	private boolean check(int[] nums, int k, int mx) {
		int cnt = 0;
		int s = 0;
		for (int x : nums) {
			if (s + x < mx) {
				s += x;
			} else {
				cnt++;
				s = 0;
			}
		}
		return cnt >= k;
	}

	public static void main(String[] args) {
		MaximizeSweetness maximizeSweetness = new MaximizeSweetness();
		int[] sweetness = {1,2,3,4,5,6,7,8,9};
		int k = 5;
		System.out.println(maximizeSweetness.maximizeSweetness(sweetness, k));
	}
}
