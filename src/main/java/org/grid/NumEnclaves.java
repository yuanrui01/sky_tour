package org.grid;


/**
 * 1020. 飞地的数量
 */
public class NumEnclaves {

    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean flag = false;

    public int numEnclaves(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    flag = false;
                    int cnt = dfs(grid, vis, m, n, i, j);
                    if (!flag)
                        ans += cnt;
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, boolean[][] vis, int m, int n, int i, int j) {
        vis[i][j] = true;
        int res = 1;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];

            if (newX >= 0 && newX < m && newY >= 0 && newY < n ){
                if (grid[newX][newY] == 1 && !vis[newX][newY]) {
                    res += dfs(grid, vis, m, n, newX, newY);
                }
            } else {
                flag = true;
            }
        }
        return res;
    }
}
