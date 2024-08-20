package org.grid;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 505. 迷宫 II
 */
public class ShortestDistance {

    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] vis = new int[m][n];
        for (int[] vi : vis) {
            Arrays.fill(vi, Integer.MAX_VALUE);
        }
        int si = start[0];
        int sj = start[1];
        int ei = destination[0];
        int ej = destination[1];
        if (si == ei && sj == ej) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{si, sj, 0});
        vis[si][sj] = 0;
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            int z = poll[2];
            if (i == ei && j == ej) {
                ans = Math.min(ans, z);
                continue;
            }
            for (int[] d : dirs) {
                int x = i + d[0], y = j + d[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                }
                int tx = x - d[0];
                int ty = y - d[1];
                int tz = z + Math.abs(tx - i) + Math.abs(ty - j);
                if (tz < vis[tx][ty]) {
                    vis[tx][ty] = tz;
                    queue.add(new int[]{tx, ty, tz});
                }
            }
        }
        return ans ==  Integer.MAX_VALUE ? -1 : ans;
    }
}
