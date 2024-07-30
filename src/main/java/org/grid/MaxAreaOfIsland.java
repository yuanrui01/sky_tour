package org.grid;


/**
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {

    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !vis[i][j])
                    ans = Math.max(ans, dfs(grid, vis, m, n, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, boolean[][] vis, int m, int n, int i, int j) {
        int res = 1;
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1 && !vis[newX][newY]) {
                res += dfs(grid, vis, m, n, newX, newY);
            }
        }
        return res;
    }
}
