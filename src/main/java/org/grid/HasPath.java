package org.grid;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 490. 迷宫Ⅰ
 */
public class HasPath {

    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        int si = start[0];
        int sj = start[1];
        int ei = destination[0];
        int ej = destination[1];
        if (si == ei && sj == ej) return true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{si, sj});
        vis[si][sj] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            if (i == ei && j == ej) return true;
            for (int[] d : dirs) {
                int x = i + d[0], y = j + d[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                }
                int tx = x - d[0];
                int ty = y - d[1];
                if (!vis[tx][ty] && maze[tx][ty] == 0) {
                    vis[tx][ty] = true;
                    queue.add(new int[] {tx, ty});
                }
            }
        }
        return false;
    }
}
