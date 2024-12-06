package org.hypnos;

/**
 * 688. 骑士在棋盘上的概率
 */
public class KnightProbability {

	private int n;
	private int[][] dirs = {{1,-2}, {2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};

	public double knightProbability(int n, int k, int row, int column) {
		this.n = n;
		return dfs(row, column, k);
	}

	private double dfs(int x, int y, int k) {
		if (k == 0) {
			return 1;
		}
		double result = 0.0;
		for (int[] dir : dirs) {
			int newX = x + dir[0];
			int newY = y + dir[1];
			if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
				result += dfs(newX, newY, k - 1) * 0.125;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		KnightProbability knightProbability = new KnightProbability();
		System.out.println(knightProbability.knightProbability(3, 1, 1, 1));
		System.out.println(knightProbability.dfs(1,2,1));
	}
}
