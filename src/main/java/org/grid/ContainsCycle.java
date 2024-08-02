package org.grid;

/**
 * 1559. 二维网格图中探测环
 */
public class ContainsCycle {

	private int[][] dirs =  {{0,1},{0,-1},{1,0},{-1,0}};
	private int[][][] preArr;
	public boolean containsCycle(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] vis = new boolean[m][n];
		preArr = new int[m][n][2];
		for (int[][] ints : preArr) {
			for (int[] anInt : ints) {
				anInt[0] = -1;
				anInt[1] = -1;
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!vis[i][j] && dfs(grid, vis, m, n, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] grid, boolean[][] vis, int m, int n, int i, int j) {
		vis[i][j] = true;
		for (int[] d : dirs) {
			int newX = i + d[0];
			int newY = j + d[1];
			if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == grid[i][j]) {
				if (vis[newX][newY] && preArr[i][j][0] != newX && preArr[i][j][1] != newY) {
					return true;
				}
				if (!vis[newX][newY]) {
					preArr[newX][newY][0] = i;
					preArr[newX][newY][1] = j;
					if (dfs(grid, vis, m, n, newX, newY))
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsCycle containsCycle = new ContainsCycle();
		char[][] grid = {{'a','b','b'},{'b','z','b'},{'b','b','a'}};
		System.out.println(containsCycle.containsCycle(grid));
	}
}
