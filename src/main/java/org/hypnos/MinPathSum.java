package org.hypnos;

import java.util.Arrays;


/**
 * 64. 最小路径和
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 1; j < n; ++j)
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0)
                    grid[0][j] = Math.min(grid[0][j], grid[0][j]);
                if (j - 1 >= 0)
                    grid[0][j] = Math.min(grid[0][j - 1], grid[0][j]);
                grid[0][j] += grid[i][j];
            }
        }
        return grid[0][n-1];
    }

    public static void main(String[] args) {
        int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
    }
}
