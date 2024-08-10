package org.grid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 */
public class MaxDistance {

	private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	public int maxDistance(int[][] grid) {
		int ans = -1;
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (grid[i][j] == 1)
					queue.add(new int[]{i,j,0});
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int[] dir : dirs) {
				int x = p[0] + dir[0];
				int y = p[1] + dir[1];
				int z = p[2];
				if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != 1) {
					ans = Math.max(ans, z + 1);
					queue.add(new int[] {x,y, z + 1});
					grid[x][y] = 1;
				}

			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
		MaxDistance maxDistance = new MaxDistance();
		System.out.println(maxDistance.maxDistance(grid));
	}
}
