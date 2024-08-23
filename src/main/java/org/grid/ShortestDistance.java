package org.grid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 317. 离建筑物最近的距离
 */
public class ShortestDistance {

	private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

	public int shortestDistance(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int ones = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1)
					ones++;
			}
		}
		if (m*n == ones)
			return -1;
		int ans = Integer.MAX_VALUE;
		boolean[][] vis = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 0) {
					queue.clear();
					for (boolean[] vi : vis) {
						Arrays.fill(vi, false);
					}
					int tmpDis = 0;
					int tmpOnes = 0;
					queue.add(new int[]{i,j,0});
					while (!queue.isEmpty()) {
						int[] poll = queue.poll();
						int x = poll[0];
						int y = poll[1];
						int z = poll[2];
						if (grid[x][y] == 1) {
							tmpOnes++;
							tmpDis += z;
							continue;
						}
						for (int[] dir : dirs) {
							int newX = x + dir[0];
							int newY = y + dir[1];
							if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != 2 && !vis[newX][newY]) {
								vis[newX][newY] = true;
								queue.add(new int[]{newX, newY, z + 1});
							}
						}
					}
					if (tmpOnes == ones) {
						ans = Math.min(ans, tmpDis);
					}
				}
			}
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}
