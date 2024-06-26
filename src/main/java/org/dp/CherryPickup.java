package org.dp;

import java.util.Arrays;


/**
 * 1463. 摘樱桃 II
 */
public class CherryPickup {

    private int m;
    private int n;
    private int[][] grid;

    public int cherryPickup(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        int[][][] memo = new int[m][n][n];
        for (int[][] rows : memo) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        return dfs(0, 0, n - 1, memo);
    }

    private int dfs(int i, int j, int k, int[][][] memo) {
        if (i == m || j < 0 || j >= n || k < 0 || k >= n)
            return 0;
        if (memo[i][j][k] != -1)
            return memo[i][j][k];
        int res = 0;
        for (int j2 = j - 1; j2 <= j + 1; ++j2) {
            for (int k2 = k - 1; k2 <= k + 1; ++k2) {
                res = Math.max(res, dfs(i + 1, j2, k2, memo));
            }
        }
        res += grid[i][j] + (k != j ? grid[i][k] : 0);
        memo[i][j][k] = res;
        return res;
    }

    public static void main(String[] args) {
        CherryPickup cherryPickup = new CherryPickup();
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(cherryPickup.cherryPickup(grid));
    }
}
