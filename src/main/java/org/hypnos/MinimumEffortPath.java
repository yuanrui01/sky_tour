package org.hypnos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1631. 最小体力消耗路径 - dijkstra's algorithm
 */
public class MinimumEffortPath {
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int[][] dist = new int[m][n];
		for (int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));
		pq.offer(new int[]{0, 0, 0});

		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int d = poll[0];
			int i = poll[1];
			int j = poll[2];

			if (i == m - 1 && j == n - 1)
				return d;
			if (d > dist[i][j])
				continue;
			for (int[] direction : directions) {
				int newI = i + direction[0];
				int newJ = j + direction[1];
				if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
					int newDist = Math.max(Math.abs(heights[newI][newJ] - heights[i][j]), dist[i][j]);
					if (newDist < dist[newI][newJ]) {
						dist[newI][newJ] = newDist;
						pq.offer(new int[]{newDist, newI, newJ});
					}
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
		int[][] heights =  {{1,2,2},{3,8,2},{5,3,5}};
		System.out.println(minimumEffortPath.minimumEffortPath(heights));
	}
}
