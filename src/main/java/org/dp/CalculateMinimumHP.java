package org.dp;

/**
 * 174. 地下城游戏
 */
public class CalculateMinimumHP {

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		// 创建 DP 表格
		int[][] dp = new int[m + 1][n + 1];

		// 将表格初始化为无穷大，除了骑士到达终点的下一个虚拟点（用于简化边界条件）
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		// 设置虚拟终点的健康点数为 1
		dp[m][n - 1] = 1;
		dp[m - 1][n] = 1;

		// 从右下角向左上角填充 DP 表
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = Math.max(minHealthOnExit - dungeon[i][j], 1);
			}
		}

		// 左上角的值即为骑士的初始健康点数
		return dp[0][0];
	}
}
