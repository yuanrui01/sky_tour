package org.hypnos;

import java.util.Arrays;

/**
 * 931. 下降路径最小和
 */
public class MinFallingPathSum {

	private int[][] cache;
	private int[][] matrix;
	private int rows;
	private int cols;

	public int minFallingPathSum(int[][] matrix) {
		this.rows = matrix.length;
		this.cols = matrix[0].length;
		this.matrix = matrix;
		cache = new int[rows][cols];
		for (int[] row : cache) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		int ans = Integer.MAX_VALUE;
		for(int j = 0; j < cols; ++j) {
			ans = Math.min(ans, dp(rows - 1, j));
		}
		return ans;
	}

	private int dp(int i, int j) {
		if (cache[i][j] != Integer.MAX_VALUE) {
			return cache[i][j];
		}
		int result = matrix[i][j];
		if (i - 1 >= 0) {
			int left = j - 1 >= 0 ? dp(i - 1, j - 1) : Integer.MAX_VALUE;
			int mid = dp(i - 1, j );
			int right = j + 1 < cols ? dp(i - 1, j + 1) : Integer.MAX_VALUE;
			result += Math.min(left, Math.min(right, mid));
		}
		cache[i][j] = result;
		return result;
	}

}
