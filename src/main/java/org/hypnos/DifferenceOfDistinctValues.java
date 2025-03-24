package org.hypnos;

/**
 * 2711. 对角线上不同值的数量差
 */
public class DifferenceOfDistinctValues {

	public int[][] differenceOfDistinctValues(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] ans = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				long l = 0L;
				int c1 = 0;
				int c2 = 0;
				int x = i, y = j;
				while (x-1 >= 0 && y-1 >= 0) {
					x--;
					y--;
					if (((l >> grid[x][y]) & 1L) == 0) {
						l |= (1L << grid[x][y]);
						c1++;
					}
				}
				x = i;
				y = j;
				l = 0L;
				while (x+1 < m && y+1 < n) {
					x++;
					y++;
					if (((l >> grid[x][y]) & 1L) == 0) {
						l |= (1L << grid[x][y]);
						c2++;
					}
				}
				ans[i][j] = Math.abs(c1 - c2);
			}
		}
		return ans;
	}
}
