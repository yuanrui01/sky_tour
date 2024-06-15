package org.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 1301. 最大得分的路径数目
 */
public class PathsWithMaxScore {
	private static final int LIMIT = 1_000_000_007;
	private int m;
	private int n;

	public int[] pathsWithMaxScore(List<String> board) {
		m = board.size();
		n = board.get(0).length();

		int[][] ans = new int[m][n];
		int[][] count = new int[m][n];
		ans[m - 1][n - 1] = 0;
		count[m - 1][n - 1] = 1;

		char[][] grid = new char[m][n];
		for (int i = 0; i < m; ++i)
			grid[i] = board.get(i).toCharArray();

		for (int j = n - 2; j >= 0; --j) {
			if (grid[m - 1][j] == 'X' || ans[m - 1][j + 1] == Integer.MIN_VALUE) {
				ans[m - 1][j] = Integer.MIN_VALUE;
				count[m - 1][j] = 0;
			} else {
				ans[m - 1][j] = ans[m - 1][j + 1] + (grid[m - 1][j] - '0');
				count[m - 1][j] = 1;
			}
		}

		for (int i = m - 2; i >= 0; --i) {
			if (grid[i][n - 1] == 'X' || ans[i + 1][n - 1] == Integer.MIN_VALUE) {
				ans[i][n - 1] = Integer.MIN_VALUE;
				count[i][n - 1] = 0;
			} else {
				ans[i][n - 1] = ans[i + 1][n - 1] + (grid[i][n - 1] - '0');
				count[i][n - 1] = 1;
			}
		}

		for (int i = m - 2; i >= 0; --i) {
			for (int j = n - 2; j >= 0; --j) {
				char c = grid[i][j];
				if (c == 'X') {
					ans[i][j] = Integer.MIN_VALUE;
					count[i][j] = 0;
					continue;
				}
				int diag = ans[i + 1][j + 1];
				int right = ans[i][j + 1];
				int bottom = ans[i + 1][j];
				int maxi = Math.max(diag, Math.max(right, bottom));
				ans[i][j] = maxi;
				if (ans[i][j] < 0)
					continue;
				else
					ans[i][j] += (grid[i][j] == 'E' ? 0 : (grid[i][j] - '0'));
				if (diag == maxi)
					count[i][j] = count[i + 1][j + 1];
				if (right == maxi)
					count[i][j] = (count[i][j] + count[i][j + 1]) % LIMIT;
				if (bottom == maxi)
					count[i][j] = (count[i][j] + count[i + 1][j]) % LIMIT;
			}
		}

		if (ans[0][0] < 0)
			return new int[]{0, 0};
		else
			return new int[]{ans[0][0], count[0][0]};
	}

	public static void main(String[] args) {
		List<String> e23 = List.of("E11345","X452XX","3X43X4","44X312","23452X","1342XS");
		PathsWithMaxScore pathsWithMaxScore = new PathsWithMaxScore();
		System.out.println(Arrays.toString(pathsWithMaxScore.pathsWithMaxScore(e23)));
	}
}
