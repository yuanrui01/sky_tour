package org.hypnos;

/**
 * 2684. 矩阵中移动的最大次数
 * 从单元格 (row, col) 可以移动到
 * (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 */
public class MaxMoves {

	private int[][] ds = {{-1,1},{0,1},{1,1}};

	public int maxMoves(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int ans = 0;
		for (int i = 0; i < m; ++i) {
			ans = Math.max(ans, dfs(grid, m, n, i, 0));
		}
		return ans;
	}


	private int dfs(int[][] grid, int m, int n, int i, int j) {
		int ans = 0;
		for (int[] d : ds) {
			int x = i + d[0];
			int y = j + d[1];
			if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[i][j]) {
				ans = Math.max(ans, dfs(grid, m, n, x, y) + 1);
			}
		}
		grid[i][j] = 0;
		return ans;
	}

	public static void main(String[] args) {
		MaxMoves maxMoves = new MaxMoves();
		int[][] grid = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
		System.out.println(maxMoves.maxMoves(grid));
	}
}
