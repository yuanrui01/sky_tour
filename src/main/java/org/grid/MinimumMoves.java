package org.grid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1210. 穿过迷宫的最少移动次数
 */
public class MinimumMoves {

	public int minimumMoves(int[][] grid) {
		int n = grid.length;
		if (n == 1)
			return 0;
		boolean[][][] vis = new boolean[n][n][2];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0,0,0}); // 行 列 方向 移动次数
		vis[0][0][0] = true;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			int d = poll[2];
			int moves = poll[3];
			if (x == n - 1 && y == n - 2 && d == 0)
				return moves;
			if (d == 0) {
				if (y + 2 < n && grid[x][y + 2] != 1 && !vis[x][y+1][0]) {
					queue.add(new int[]{x, y + 1, 0, moves + 1});
					vis[x][y+1][0] = true;
				}
				if (x + 1 < n && y + 1 < n && grid[x+1][y+1]!= 1 && grid[x+1][y] != 1 && !vis[x+1][y][0]) {
					queue.add(new int[]{x+1,y,0,moves + 1});
					vis[x+1][y][0] = true;
				}
				if (x + 1 < n && y + 1 < n && grid[x+1][y] != 1 && grid[x+1][y+1] != 1 && !vis[x][y][1]) {
					queue.add(new int[]{x,y,1,moves + 1});
					vis[x][y][1] = true;
				}
			} else if (d == 1) {
				if (x + 2 < n && grid[x+2][y] != 1 && !vis[x+1][y][1]) {
					queue.add(new int[]{x+1, y, 1, moves + 1});
					vis[x+1][y][1] = true;
				}
				if (x + 1 < n && y + 1 < n && grid[x][y+1] != 1 && grid[x+1][y+1] != 1 && !vis[x][y+1][1]) {
					queue.add(new int[]{x,y+1,1, moves + 1});
					vis[x][y+1][1] = true;
				}
				if (x + 1 < n && y + 1 < n && grid[x + 1][y + 1] != 1 && grid[x][y + 1] != 1 && !vis[x][y][0]) {
					queue.add(new int[]{x,y,0, moves + 1});
					vis[x][y][0] = true;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = {{0,0,0,0,0,1},
				{1,1,0,0,1,0},
				{0,0,0,0,1,1},
				{0,0,1,0,1,0},
				{0,1,1,0,0,0},
				{0,1,1,0,0,0}};
		MinimumMoves minimumMoves = new MinimumMoves();
		System.out.println(minimumMoves.minimumMoves(grid));
	}
}
