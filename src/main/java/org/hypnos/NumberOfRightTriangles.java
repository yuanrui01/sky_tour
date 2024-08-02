package org.hypnos;


/**
 * 3128. 直角三角形
 */
public class NumberOfRightTriangles {

    public long numberOfRightTriangles(int[][] grid) {
        long ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        long[] rows = new long[m];
        long[] cols = new long[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += (rows[i] - 1) * (cols[j] - 1) * grid[i][j];
            }
        }
        return ans;
    }
}
