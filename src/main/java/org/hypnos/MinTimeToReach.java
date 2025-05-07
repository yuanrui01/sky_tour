package org.hypnos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3341. 到达最后一个房间的最少时间 I
 */
public class MinTimeToReach {

	private int n, m;
	private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public int minTimeToReach(int[][] mt) {
		n = mt.length;
		m = mt[0].length;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		int[][] visited = new int[n][m];
		for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);
		pq.offer(new int[]{0, 0, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int i = curr[0], j = curr[1], t = curr[2];

			// 再判断
			if (t > visited[i][j]) continue;

			// 到达终点
			if (i == n - 1 && j == m - 1) return t;

			for (int[] dir : DIRS) {
				int ni = i + dir[0], nj = j + dir[1];

				if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
					int newTime = Math.max(t, mt[ni][nj]) + 1;

					if (newTime < visited[ni][nj]) {
						visited[ni][nj] = newTime;
						pq.offer(new int[]{ni, nj, newTime});
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		/**
		 * [[94,79,62,27,69,84],[6,32,11,82,42,30]]
		 */
		MinTimeToReach minTimeToReach = new MinTimeToReach();
		int[][] mt1 = {{0,4},{4,4}};
		int[][] mt2 = {{0,0,0}, {0,0,0}};
		int[][] mt3 = {{94,79,62,27,69,84},{6,32,11,82,42,30}};
		System.out.println(minTimeToReach.minTimeToReach(mt1));
		System.out.println(minTimeToReach.minTimeToReach(mt2));
		System.out.println(minTimeToReach.minTimeToReach(mt3));
	}
}
