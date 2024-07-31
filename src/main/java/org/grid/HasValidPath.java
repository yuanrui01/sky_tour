package org.grid;


/**
 * 1391. 检查网格中是否存在有效路径
 */
public class HasValidPath {

    private boolean flag = false;
    private static final int[][][] dirs
            = {{{}}, {{0,1},{0,-1}}, {{1,0},{-1,0}}, {{0,-1},{1,0}}, {{0,1},{1,0}}, {{0,-1},{-1,0}}, {{0,1},{-1,0}}};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        dfs(grid, vis, m, n, 0, 0);
        return flag;
    }

    private boolean dfs(int[][] grid, boolean[][] vis, int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1)
            return flag = true;
        vis[i][j] = true;
        for (int[] dir : dirs[grid[i][j]]) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n
                    && !vis[newX][newY] && check(grid, i, j, newX, newY))
                if (dfs(grid, vis, m, n, newX, newY))
                    return true;
        }
        return false;
    }

    private boolean check(int[][] grid, int x, int y, int newX, int newY) {
        for (int[] d : dirs[grid[newX][newY]])
            if (newX + d[0] == x && newY + d[1] == y)
                return true;
        return false;
    }
}
