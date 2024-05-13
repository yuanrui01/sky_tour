package org.hypnos;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1631. 最小体力消耗路径
 */
public class MinimumEffortPath {
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int[][] dis = new int[m][n];
		for (int[] row : dis) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dis[0][0] = 0; // 初始化start

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.offer(new int[]{0, 0, 0}); // {dis, i, j}

		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 右，左，下，上

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int d = curr[0];
			int i = curr[1];
			int j = curr[2];

			if (i == m - 1 && j == n - 1) {
				return d;
			}

			if (d > dis[i][j]) {
				continue;
			}

			for (int[] dir : directions) {
				int newI = i + dir[0];
				int newJ = j + dir[1];

				if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
					int nd = Math.max(Math.abs(heights[newI][newJ] - heights[i][j]), dis[i][j]);
					if (nd < dis[newI][newJ]) {
						dis[newI][newJ] = nd;
						pq.offer(new int[]{nd, newI, newJ});
					}
				}
			}
		}

		// 如果无法到达终点，返回-1（或任何合适的错误代码）
		return -1;
	}

	public static void main(String[] args) {
		MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
		int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		System.out.println(minimumEffortPath.minimumEffortPath(heights));
	}
}
