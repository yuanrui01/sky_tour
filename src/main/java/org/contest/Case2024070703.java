package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024070703 {

	public static int countBalancedSubmatrices(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] prefixX = new int[m + 1][n + 1];
		int[][] prefixY = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] - prefixX[i - 1][j - 1];
				prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] - prefixY[i - 1][j - 1];
				if (grid[i - 1][j - 1] == 'X') {
					prefixX[i][j]++;
				} else if (grid[i - 1][j - 1] == 'Y') {
					prefixY[i][j]++;
				}
			}
		}

		int ans = 0;
		for (int r = 1; r <= m; r++) {
			for (int c = 1; c <= n; c++) {
				int xCount = prefixX[r][c];
				int yCount = prefixY[r][c];
				if (xCount > 0 && xCount == yCount) {
					ans++;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Case2024070703 case2024070703 = new Case2024070703();

		char[][] grid = {{'.','.'},{'.','.'}};

		System.out.println(case2024070703.countBalancedSubmatrices(grid));
	}
}
