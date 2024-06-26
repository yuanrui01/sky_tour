package org.dp;

/**
 * 2328. 网格图中递增路径的数目
 */
public class CountPaths {

    private static final int MOD = 1_000_000_007;
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int m;
    private int n;
    private int[][] grid;
    private long[][] cache;
    public int countPaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.cache = new long[m][n];

        long ans = 0;
        for(int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = (ans + count(i, j)) % MOD;
            }
        }

        return (int) ans;
    }


    private long count(int i, int j) {
        if (cache[i][j] != 0)
            return cache[i][j];
        long ans = 1;
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] > grid[i][j]) {
                ans = (ans + count(newX, newY)) % MOD;
            }
        }
        return cache[i][j] = ans;
    }
}
