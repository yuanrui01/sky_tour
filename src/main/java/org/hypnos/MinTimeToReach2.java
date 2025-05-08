package org.hypnos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 3342. 到达最后一个房间的最少时间 II
 */
public class MinTimeToReach2 {
	private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


	public int minTimeToReach(int[][] moveTime) {
		int n = moveTime.length;
		int m = moveTime[0].length;
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		int[][] vis = new int[n][m];
		for (int[] vi : vis) {
			Arrays.fill(vi, Integer.MAX_VALUE);
		}
		queue.add(new int[]{0,0,0});
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int i = poll[0], j = poll[1], t = poll[2];
			if (i == n - 1 && j == m - 1) return t;
			if (t > vis[i][j]) continue;
			int inc = (i + j) % 2 == 0 ? 1 : 2;
			for (int[] dir : dirs) {
				int x = i + dir[0];
				int y = j + dir[1];
				if (x >= 0 && x < n && y >= 0 && y < m) {
					int nt = Math.max(t, moveTime[x][y]) + inc;
					if (nt < vis[x][y]) {
						vis[x][y] = nt;
						queue.add(new int[]{x,y,nt});
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MinTimeToReach2 minTimeToReach2 = new MinTimeToReach2();
		int[][] mt = {{0,4},{4,4}};
		System.out.println(minTimeToReach2.minTimeToReach(mt));
	}
}
