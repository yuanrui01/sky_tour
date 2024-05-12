package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanrui
 */
public class MaxScore {

	public int maxScore(List<List<Integer>> grid) {

		int m = grid.size();
		int n = grid.get(0).size();
		int[][] dp = new int[m][n];

		// 初始化第一行
		dp[0][0] = grid.get(0).get(0);
		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + grid.get(0).get(j);
		}

		// 初始化第一列
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid.get(i).get(0);
		}

		// 填充剩余部分
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid.get(i).get(j);
			}
		}

		// 找到最大得分
		int maxScore = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				maxScore = Math.max(maxScore, dp[i][j]);
			}
		}

		return maxScore;
	}

	public static void main(String[] args) {
		List<List<Integer>> grid = new ArrayList<List<Integer>>();

		grid.add(List.of(9,5,7,3));
		grid.add(List.of(8,9,6,1));
		grid.add(List.of(6,7,14,3));
		grid.add(List.of(2,5,3,1));
		MaxScore maxScore = new MaxScore();
		System.out.println(maxScore.maxScore(grid));
	}
}
