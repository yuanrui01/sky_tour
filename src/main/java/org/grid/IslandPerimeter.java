package org.grid;


/**
 * 463. 岛屿的周长
 */
public class IslandPerimeter {

    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1)
                    return dfs(grid, vis, m, n, i, j);
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, boolean[][] vis, int m, int n, int i, int j) {
        int res = 0;
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                if (grid[newX][newY] == 1 && !vis[newX][newY]) {
                    // 再探
                    res += dfs(grid, vis, m, n, newX, newY);
                } else if (grid[newX][newY] == 0) {
                    // 有水
                    res++;
                }
            } else {
                // 边界方向
                res++;
            }
        }
        return res;
    }
}
