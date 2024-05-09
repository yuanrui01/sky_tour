package org.hypnos;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class ShipWithinDays {

	public static int shipWithinDays(int[] weights, int days) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < weights.length; i++) {
			right += weights[i];
			left = Math.max(left, weights[i]);
		}
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (!isAble(weights, mid, days)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private static boolean isAble(int[] weights, int capacity, int days) {
		int rest = capacity;
		int ans = 0;
		int idx = 0;
		while (idx < weights.length) {
			while (idx < weights.length && rest >= weights[idx]) {
				rest -= weights[idx++];
			}
			ans++;
			rest = capacity;
		}
		return ans <= days;
	}


	public static void main(String[] args) {
		int[] weights = {10,50,100,100,50,100,100,100};
		int days = 5;
		System.out.println( shipWithinDays(weights, days));
	}
}
