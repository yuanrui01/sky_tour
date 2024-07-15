package org.hypnos;

/**
 * 807. 保持城市天际线
 */
public class MaxIncreaseKeepingSkyline {

	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int ans = 0;
		int m = grid.length;
		int n = grid[0].length;
		int[] rmx = new int[m];
		int[] cmx = new int[n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				rmx[i] = Math.max(rmx[i], grid[i][j]);
				cmx[j] = Math.max(cmx[j], grid[i][j]);
			}
		}
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				ans += Math.min(rmx[i], cmx[j]) - grid[i][j];
		return ans;
	}
}
