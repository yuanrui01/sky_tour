package org.grid;


/**
 * 1254. 统计封闭岛屿的数目
 */
public class ClosedIsland {

    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean flag = true;

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    flag = true;
                    dfs(grid, vis, m, n, i, j);
                    if (flag)
                        ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, boolean[][] vis, int m, int n, int i, int j) {
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                if (grid[newX][newY] == 0 && !vis[newX][newY])
                    dfs(grid, vis, m, n, newX, newY);
                else if (grid[newX][newY] == 1)
                    flag = false;
            } else {
                flag = false;
            }
        }
    }
}
