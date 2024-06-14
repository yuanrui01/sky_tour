package org.dp;

import java.math.BigInteger;

/**
 * 1594. 矩阵的最大非负积
 */
public class MaxProductPath {

	private static final long LIMIT = 1_000_000_007L;

	private int m;
	private int n;
	private BigInteger ans;
	public int maxProductPath(int[][] grid) {
		this.m = grid.length;
		this.n = grid[0].length;
		this.ans = BigInteger.valueOf(-1L);
		boolean[][] vis = new boolean[m][n];
		dfs(grid, vis, BigInteger.valueOf(1), 0, 0);
		return ans.compareTo(BigInteger.ZERO) < 0 ? -1 : ans.mod(BigInteger.valueOf(1000000007L)).intValue();
	}


	private void dfs(int[][] grid, boolean[][] vis, BigInteger pre, int i, int j) {
		if (pre.equals(BigInteger.ZERO)) {
			ans = ans.max(BigInteger.ZERO);
			return;
		}
		BigInteger multiply = pre.multiply(BigInteger.valueOf(grid[i][j]));
		if (i == m - 1 && j == n - 1) {
			ans = ans.max(multiply);
			return;
		}

		vis[i][j] = true;
		if (i != m - 1 && !vis[i + 1][j])
			dfs(grid, vis, multiply, i + 1, j);
		if (j < n - 1 && !vis[i][j + 1])
			dfs(grid, vis, multiply, i, j + 1);
		vis[i][j] = false;
	}

	public static void main(String[] args) {
		int[][] grid = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
		MaxProductPath maxProductPath = new MaxProductPath();
		System.out.println(maxProductPath.maxProductPath(grid));
	}
}
