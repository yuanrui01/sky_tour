package org.hypnos;

import java.util.Arrays;

/**
 * 62. 不同路径
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                memo[j] = memo[j] + memo[j - 1];
        return memo[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths.uniquePaths(m,n));
    }
}
