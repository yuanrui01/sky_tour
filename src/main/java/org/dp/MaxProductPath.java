package org.dp;

/**
 * 1594. 矩阵的最大非负积
 */
public class MaxProductPath {

	private static final long LIMIT = 1_000_000_007L;

	private int m;
	private int n;
	private long ans;
	public int maxProductPath(int[][] grid) {
		this.m = grid.length;
		this.n = grid[0].length;
		this.ans = -1;
		boolean[][] vis = new boolean[m][n];
		dfs(grid, vis, 1L, 0, 0);
		return (int) (ans % LIMIT);
	}

	private void dfs(int[][] grid, boolean[][] vis, long pre, int i, int j) {
		if (pre == 0) {
			ans = Math.max(ans, 0);
			return;
		}
		long tmp = pre * grid[i][j];
		if (i == m - 1 && j == n - 1) {
			ans = Math.max(ans, tmp);
			return ;
		}
		vis[i][j] = true;
		if (i != m - 1 && !vis[i + 1][j])
			dfs(grid, vis, tmp, i + 1, j);
		if (j < n - 1 && !vis[i][j + 1])
			dfs(grid, vis, tmp, i, j + 1);
		vis[i][j] = false;
	}

	public static void main(String[] args) {
		int[][] grid = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
		MaxProductPath maxProductPath = new MaxProductPath();
		System.out.println(maxProductPath.maxProductPath(grid));
	}
}
