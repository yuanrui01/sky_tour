package org.ds;

/**
 * 1014. 最佳观光组合
 */
public class MaxScoreSightseeingPair {

	public int maxScoreSightseeingPair(int[] values) {
		int max = values[0];
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < values.length; ++i) {
			int t = values[i] - i;
			ans = Math.max(ans, max + t);
			max = Math.max(max, values[i] + i);
		}
		return ans;
	}
}
