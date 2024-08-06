package org.grid;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 994. 腐烂的橘子
 */
public class OrangesRotting {

    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        if (queue.isEmpty() && fresh > 0)
            return -1;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0];
            int j = p[1];
            int z = p[2];
            ans = Math.max(ans, z);
            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    fresh--;
                    queue.add(new int[]{x, y, z + 1});
                }
            }
        }
        return fresh == 0 ? ans : -1;
    }

}
