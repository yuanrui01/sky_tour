package org.grid;

import java.util.Arrays;


/**
 * 1034. 边界着色
 */
public class ColorBorder {

    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            System.arraycopy(grid[i], 0, ans[i], 0, n);
        }
        dfs(ans, grid, vis, m, n, color, row, col);
        return ans;
    }

    private void dfs(int[][] ans, int[][] grid, boolean[][] vis, int m, int n, int color, int i, int j) {
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                if (grid[newX][newY] == grid[i][j] && !vis[newX][newY]) {
                    dfs(ans, grid, vis, m, n, color, newX, newY);
                } else if (grid[newX][newY] != grid[i][j]) {
                    ans[i][j] = color;
                }
            } else {
                ans[i][j] = color;
            }
        }
    }

    public static void main(String[] args) {
        ColorBorder colorBorder = new ColorBorder();
        int[][] grid = {{1,2,2},{2,3,2}};
        int row = 0;
        int col = 1;
        int color = 3;
        int[][] ans = colorBorder.colorBorder(grid, row, col, color);
        for (int[] ints : ans) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
