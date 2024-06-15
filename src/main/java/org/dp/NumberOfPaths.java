package org.dp;

/**
 * 2435. 矩阵中和能被 K 整除的路径
 */
public class NumberOfPaths {

	private static final int LIMIT = 1_000_000_007;

	public int numberOfPaths(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		int[][][] dp = new int[m + 1][n + 1][k];
		dp[0][1][0] = 1;
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				for (int y = 0; y < k; ++y)
					dp[i + 1][j + 1][(y + grid[i][j]) % k] = (dp[i][j + 1][y] + dp[i + 1][j][y]) % LIMIT;
		return dp[m][n][0];
	}
}
