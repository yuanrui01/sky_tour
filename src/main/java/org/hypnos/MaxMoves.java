package org.hypnos;

/**
 * 2684. 矩阵中移动的最大次数
 */
public class MaxMoves {

	private int[][] cache;
	private int[][] grid;
	private int m;
	private int n;

	public int maxMoves(int[][] grid) {
		this.m = grid.length;
		this.n = grid[0].length;
		this.cache = new int[m][n];
		this.grid = grid;
		int ans = 0;
		for (int i = 0; i < m; i++) {
			ans = Math.max(ans, dp(i, 0));
		}
		return ans;
	}

	private int dp(int i, int j) {
		if (j == n - 1)
			return 0;
		if (cache[i][j] != 0)
			return cache[i][j];
		int ans = 0;
		if (i - 1 >= 0 && grid[i - 1][j + 1] > grid[i][j]) {
			ans = Math.max(ans, dp(i - 1, j + 1) + 1);
		}
		if (grid[i][j + 1] > grid[i][j]) {
			ans = Math.max(ans, dp(i, j + 1) + 1);
		}
		if (i + 1 < m && grid[i + 1][j + 1] > grid[i][j]) {
			ans = Math.max(ans, dp(i + 1, j + 1) + 1);
		}
		cache[i][j] = ans;
		return ans;
	}
}
