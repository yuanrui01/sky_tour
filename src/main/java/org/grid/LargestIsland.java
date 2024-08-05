package org.grid;


import java.util.*;

/**
 * 827. 最大人工岛
 */
public class LargestIsland {

    private int[][] dirs = {{0,1}, {0,-1},{1,0},{-1,0}};
    private int initTag = 2;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MIN_VALUE;
        Map<Integer, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int islandSize = dfs(grid, initTag, n, i, j);
                    sizeMap.put(initTag, islandSize);
                    initTag++;
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int tAns = 1;
                    set.clear();
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1 && set.add(grid[x][y]))
                            tAns += sizeMap.get(grid[x][y]);
                    }
                    ans = Math.max(ans, tAns);
                }
            }
        }
        return ans == Integer.MIN_VALUE ? n * n : ans;
    }

    private int dfs(int[][] grid, int initTag, int n, int i, int j) {
        grid[i][j] = initTag;
        int ans = 1;
        for (int[] d : dirs) {
            int newX = i + d[0];
            int newY = j + d[1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 1)
                ans += dfs(grid, initTag, n, newX, newY);
        }
        return ans;
    }
}
