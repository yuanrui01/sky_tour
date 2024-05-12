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
		if (k == 0)
			return sum;
		k++;
		int left = min;
		int right = sum;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (!check(sweetness, k, mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return check(sweetness, k, left) ? left : left - 1;
	}

	private boolean check(int[] nums, int k, int mx) {
		int cnt = 0;
		int s = 0;
		for (int x : nums) {
			if (x >= mx) {
				cnt++;
				s = 0;
			} else if (s + x <= mx) {
				s += x;
			} else {
				cnt += 1;
				s = x;
			}
		}
		return cnt > k;
	}

	public static void main(String[] args) {
		MaximizeSweetness maximizeSweetness = new MaximizeSweetness();
		int[] sweetness = {90670,55382,95298,95795,73204,41464,18675,30104,47442,55307};
		int k = 6;
		System.out.println(maximizeSweetness.maximizeSweetness(sweetness, k));
	}
}
