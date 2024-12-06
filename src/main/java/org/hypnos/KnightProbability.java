package org.hypnos;

import java.util.Arrays;

/**
 * 688. 骑士在棋盘上的概率
 */
public class KnightProbability {

	private int n;
	private int[][] dirs = {{1,-2}, {2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
	private double[][][] cache;

	public double knightProbability(int n, int k, int row, int column) {
		this.n = n;
		cache = new double[n][n][k + 1];
		for (double[][] cs : cache) {
			for (double[] c : cs) {
				Arrays.fill(c, -1);
			}
		}
		return dfs(row, column, k);
	}

	private double dfs(int x, int y, int k) {
		if (k == 0) {
			return 1;
		}
		if (cache[x][y][k] != -1) return cache[x][y][k];
		double result = 0.0;
		for (int[] dir : dirs) {
			int newX = x + dir[0];
			int newY = y + dir[1];
			if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
				result += dfs(newX, newY, k - 1) * 0.125;
			}
		}
		return cache[x][y][k] = result;
	}

	public static void main(String[] args) {
		KnightProbability knightProbability = new KnightProbability();
		System.out.println(knightProbability.knightProbability(8, 30, 6, 4));
	}
}
