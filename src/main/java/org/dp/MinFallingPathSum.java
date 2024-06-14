package org.dp;

/**
 * 1289. 下降路径最小和 II
 */
public class MinFallingPathSum {

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 2; i >=0; --i) {
            for (int j = 0; j < n; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    if (k == j)
                        continue;
                    min = Math.min(min, grid[i + 1][k]);
                }
                grid[i][j] += min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int num : grid[0])
            ans = Math.min(ans, num);
        return ans;
    }
}
