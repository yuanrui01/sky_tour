package org.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * 提交尝试
 */
public class PacificAtlantic {

    private boolean pacific = false;
    private boolean atlantic = false;

    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                pacific = false;
                atlantic = false;
                for (boolean[] vi : vis) {
                    Arrays.fill(vi, false);
                }
                dfs(heights, vis, m, n, i, j);
                if (pacific && atlantic)
                    ans.add(List.of(i, j));
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, boolean[][] vis, int m, int n, int i, int j) {
        vis[i][j] = true;
        for (int[] d : dirs) {
            int newX = i + d[0];
            int newY = j + d[1];
            if (newX < 0 || newY < 0) {
                pacific = true;
            }
            if (newX >= m || newY >= n) {
                atlantic = true;
            }
            if (newX >= 0 && newX < m && newY >= 0 && newY < n
                    && !vis[newX][newY] && heights[newX][newY] <= heights[i][j]) {
                dfs(heights, vis, m, n, newX, newY);
            }
        }
    }
}
