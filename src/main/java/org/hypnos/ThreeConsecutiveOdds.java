package org.hypnos;

/**
 * 1550. 存在连续三个奇数的数组
 */
public class ThreeConsecutiveOdds {

	public boolean threeConsecutiveOdds(int[] arr) {
		int n = arr.length;
		if (n < 3) return false;

		for(int i = 0; i < n - 2; i++) {
			if ((arr[i]&1) == 1 && (arr[i + 1]&1) == 1 && (arr[i + 2]&1) == 1) {
				return true;
			}
		}
		return false;
	}

}
