package org.contest;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class Case2024092802 {

	public long maximumTotalSum(int[] maximumHeight) {
		Arrays.sort(maximumHeight);
		long ans = 0;
		int cur = Integer.MAX_VALUE;
		for (int i = maximumHeight.length - 1; i >= 0; i--) {
			if (cur > maximumHeight[i]) {
				cur = maximumHeight[i];
			} else {
				cur--;
			}
			if (cur <= 0) {
				return -1;
			}
			ans += cur;
		}
		return ans;
	}


	public static void main(String[] args) {

	}
}
