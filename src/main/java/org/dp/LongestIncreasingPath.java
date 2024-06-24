package org.dp;

/**
 * 329. 矩阵中的最长递增路径
 */
public class LongestIncreasingPath {

	private static final int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

	public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = 0;
		int[][] cache = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				ans = Math.max(ans, dfs(matrix, cache, m, n, i, j));
			}
		}
		return ans;
	}

	private int dfs(int[][] matrix, int[][] cache, int m, int n, int i, int j) {
		if (cache[i][j] != 0)
			return cache[i][j];
		int ans = 0;
		for (int[] direction : directions) {
			int newX = i + direction[0];
			int newY = j + direction[1];
			if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[i][j])
				ans = Math.max(ans, dfs(matrix, cache, m, n, newX, newY));
		}
		return cache[i][j] = ans + 1;
	}

	public static void main(String[] args) {
		int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
		LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
		System.out.println(longestIncreasingPath.longestIncreasingPath(matrix));
	}
}
