package org.dp;

/**
 * 1594. 矩阵的最大非负积
 */
public class MaxProductPath {

	private static final long LIMIT = 1_000_000_007L;
	public int maxProductPath(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		long[][] memoMax = new long[m][n];
		long[][] memoMin = new long[m][n];

		memoMax[0][0] = memoMin[0][0] = grid[0][0];
		for (int j = 1; j < n; ++j)
			memoMin[0][j] = memoMax[0][j] = grid[0][j] * memoMin[0][j - 1];
		for (int i = 1; i < m; ++i)
			memoMin[i][0] = memoMax[i][0] = grid[i][0] * memoMin[i - 1][0];

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (grid[i][j] >= 0) {
					memoMax[i][j] = Math.max(memoMax[i - 1][j] * grid[i][j], memoMax[i][j - 1] * grid[i][j]);
					memoMin[i][j] = Math.min(memoMin[i - 1][j] * grid[i][j], memoMin[i][j - 1] * grid[i][j]);
				} else {
					memoMax[i][j] = Math.max(memoMin[i - 1][j] * grid[i][j], memoMin[i][j - 1] * grid[i][j]);
					memoMin[i][j] = Math.min(memoMax[i - 1][j] * grid[i][j], memoMax[i][j - 1] * grid[i][j]);
				}
			}
		}
		return (int) (Math.max(-1, memoMax[m - 1][n - 1]) % LIMIT);
	}

	public static void main(String[] args) {
		int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};
		MaxProductPath maxProductPath = new MaxProductPath();
		System.out.println(maxProductPath.maxProductPath(grid));
	}
}
