package org.hypnos;


import java.util.Arrays;

/**
 * 2209. 用地毯覆盖后的最少白色砖块
 */
public class MinimumWhiteTiles {

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        int[][] memo = new int[m][numCarpets+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, numCarpets, floor.toCharArray(), memo, carpetLen);
    }

    private int dfs(int i, int j, char[] floor, int[][] memo, int carpetLen) {
        if (i < carpetLen * j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 不覆盖
        int res = dfs(i-1, j, floor, memo, carpetLen) + (floor[i] - '0');
        if (j > 0 && floor[i] == '1') {
            // 覆盖
            res = Math.min(res, dfs(i - carpetLen, j - 1, floor, memo, carpetLen));
        }
        return memo[i][j] = res;
    }

    public int minimumWhiteTiles2(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        int[][] dp = new int[numCarpets+1][m];
        char[] f = floor.toCharArray();
        dp[0][0] = f[0] - '0';
        for (int i = 1; i < m; ++i) {
            dp[0][i] = (f[i] - '0') + dp[0][i-1];
        }
        for (int i = 1; i <= numCarpets; ++i) {
            for (int j = i * carpetLen; j < m; ++j) {
                dp[i][j] = Math.min(dp[i-1][j-carpetLen], dp[i][j-1] + (f[j]-'0'));
            }
        }
        return dp[numCarpets][m-1];
    }

    public static void main(String[] args) {
        String floor = "1110111";
        int numCarpets = 2;
        int carpetLen = 1;
        MinimumWhiteTiles minimumWhiteTiles = new MinimumWhiteTiles();
        System.out.println(minimumWhiteTiles.minimumWhiteTiles2(floor, numCarpets, carpetLen));
    }
}
