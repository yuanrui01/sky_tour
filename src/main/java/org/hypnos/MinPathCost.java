package org.hypnos;

/**
 * 2304. 网格中的最小路径代价
 */
public class MinPathCost {

	private int m;
	private int n;
	private int[][] cache;
	private int[][] grid;
	private int[][] moveCost;

	public int minPathCost(int[][] grid, int[][] moveCost) {
		this.m = grid.length;
		this.n = grid[0].length;
		this.grid = grid;
		this.moveCost = moveCost;
		this.cache = new int[m][n];

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n ; ++i) {
			ans = Math.min(ans, dp(0, i));
		}
		return ans;
	}

	private int dp(int i, int j) {
		if (i == m - 1)
			return grid[i][j];
		if (cache[i][j] != 0)
			return cache[i][j];
		int ans = Integer.MAX_VALUE;
		for(int k = 0; k < n; ++k) {
			ans = Math.min(ans, dp(i + 1, k) + moveCost[grid[i][j]][k]);
		}
		ans += grid[i][j];
		cache[i][j] = ans;
		return ans;
	}


	public int minPathCost2(int[][] grid, int[][] moveCost) {
		int m = grid.length;
		int n = grid[0].length;

		for (int i = m - 2; i >= 0; --i) {
			for (int j = 0; j < n; ++j) {
				int res = Integer.MAX_VALUE;
				for (int k = 0; k < n; ++k) {
					res = Math.min(res, moveCost[grid[i][j]][k] + grid[i + 1][k]);
				}
				grid[i][j] += res;
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int num : grid[0])
			ans = Math.min(ans, num);
		return ans;
	}

	public static void main(String[] args) {
		int[][] grid = {{5,3},{4,0},{2,1}};
		int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};

		int i = new MinPathCost().minPathCost(grid, moveCost);
		System.out.println(i);
	}
}
