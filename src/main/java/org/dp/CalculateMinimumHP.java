package org.dp;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 */
public class CalculateMinimumHP {

	public int calculateMinimumHP(int[][] dungeon) {
		// 定义f(i,j)为 从 （i，j）到终点所需要的最少生命值
		// f(i,j) = Max(1, Min(f(i, j + 1)， f(i+1, j)) - dungeon(i, j))
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m + 1][n + 1];
		// 初始化状态
		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);
		dp[m][n - 1] = 1;
		dp[m - 1][n] = 1;
		for(int i = m - 1; i >= 0; --i)
			for (int j = n - 1; j >= 0;  --j)
				dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] dungeon =  {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		CalculateMinimumHP calculateMinimumHP = new CalculateMinimumHP();
		System.out.println(calculateMinimumHP.calculateMinimumHP(dungeon));
	}
}
