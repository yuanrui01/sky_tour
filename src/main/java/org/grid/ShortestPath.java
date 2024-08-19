package org.grid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1293. 网格中的最短路径
 */
public class ShortestPath {

	private int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};

	public int shortestPath(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		if (m == 1 && n == 1) return 0;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] vis = new boolean[m][n][k + 1];
		queue.add(new int[]{0, 0, 0, k});
		vis[0][0][k] = true;
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
					if (grid[x][y] == 0 && !vis[x][y][r]) {
						queue.add(new int[]{x,y,z+1,r});
						vis[x][y][r] = true;
					} else if (grid[x][y] == 1 && r > 0 && !vis[x][y][r - 1]) {
						queue.add(new int[]{x,y,z+1,r-1});
						vis[x][y][r - 1] = true;
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
