package org.grid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1293. 网格中的最短路径
 */
public class ShortestPath {

	private int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};

	public int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		if (k >= m + n - 3) return m + n - 2;
		Queue<int[]> queue = new LinkedList<>();
		int[][] vis = new int[m][n];
		for (int[] vi : vis)
			Arrays.fill(vi, -1);
		queue.add(new int[]{0, 0, 0, k});
		vis[0][0] = k;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			for (int[] dir : dirs) {
				int x = poll[0] + dir[0];
				int y = poll[1] + dir[1];
				int z = poll[2];
				int r = poll[3];
				if (x >= 0 && x < m && y >= 0 && y < n) {
					if (x == m - 1 && y == n - 1) {
						return z + 1;
					}
					r -= grid[x][y];
					if (r >= 0 && r > vis[x][y]) {
						queue.add(new int[]{x, y, z + 1, r});
						vis[x][y] = r;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		int k = 1;
		ShortestPath shortestPath = new ShortestPath();
		System.out.println(shortestPath.shortestPath(grid, k));
	}
}
