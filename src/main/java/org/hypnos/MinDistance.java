package org.hypnos;

import java.util.Arrays;

/**
 * 72. 编辑距离
 */
public class MinDistance {

	public int minDistance(String word1, String word2) {
		char[] a1 = word1.toCharArray();
		char[] a2 = word2.toCharArray();
		int n = a1.length;
		int m = a2.length;
		int[][] memo = new int[n+1][m+1];
		for (int[] me : memo) {
			Arrays.fill(me, -1);
		}
		return dp(n-1,m-1, memo,a1,a2);
	}

	private int dp(int i, int j, int[][] memo, char[] a1, char[] a2) {
		if (i < 0) {
			return j + 1;
		}
		if (j < 0) {
			return i + 1;
		}
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		if (a1[i] == a2[j]) {
			return memo[i][j] = dp(i-1, j-1, memo, a1, a2);
		}
		return memo[i][j] = Math.min(dp(i,j-1, memo, a1, a2), Math.min(dp(i-1, j, memo, a1, a2), dp(i-1,j-1,memo,a1,a2))) + 1;
	}
}
