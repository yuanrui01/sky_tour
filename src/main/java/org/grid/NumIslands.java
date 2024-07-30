package org.grid;


/**
 * 200. 岛屿数量
 */
public class NumIslands {

    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    ans++;
                    dfs(grid, m, n, i, j, vis);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int m, int n, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !vis[newX][newY] && grid[i][j] == '1')
                dfs(grid, m, n, newX, newY, vis);
        }
    }
}
