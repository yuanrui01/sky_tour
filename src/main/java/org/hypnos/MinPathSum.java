package org.hypnos;

import java.util.Arrays;


/**
 * 64. 最小路径和
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0)
                    memo[j] = Math.min(memo[j], memo[j]);
                if (j - 1 >= 0)
                    memo[j] = Math.min(memo[j - 1], memo[j]);
                if (memo[j] == Integer.MAX_VALUE)
                    memo[j] = 0;
                memo[j] += grid[i][j];
            }
        }
        return memo[n-1];
    }

    public static void main(String[] args) {
        int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
    }
}
