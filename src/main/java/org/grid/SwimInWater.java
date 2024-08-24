package org.grid;

import java.util.ArrayList;
import java.util.List;

/**
 * 778. 水位上升的泳池中游泳
 */
public class SwimInWater {

	private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

	public int swimInWater(int[][] grid) {
		int n = grid.length;
		if (n == 1)
			return 0;
		boolean[][] vis = new boolean[n][n];
		List<int[]> points = new ArrayList<>();
		points.add(new int[]{0,0});
		vis[0][0] = true;
		int max = grid[0][0];
		while (true) {
			int[] added = null;
			int tmpMin = Integer.MAX_VALUE;
			for (int[] point : points) {
				int x = point[0];
				int y = point[1];
				for (int[] dir : dirs) {
					int newX = x + dir[0];
					int newY = y + dir[1];
					if (newX >= 0 && newX < n && newY >= 0 && newY < n && !vis[newX][newY] && grid[newX][newY] < tmpMin) {
						tmpMin = grid[newX][newY];
						added = new int[]{newX, newY};
					}
				}
			}
			if (added == null) {
				return -1;
			} else {
				max = Math.max(max, grid[added[0]][added[1]]);
				vis[added[0]][added[1]] = true;
				points.add(added);
				if (added[0] == n - 1 && added[1] == n - 1) {
					return max;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = {{0,2},{1,3}};
		SwimInWater swimInWater = new SwimInWater();
		System.out.println(swimInWater.swimInWater(grid));
	}
}
