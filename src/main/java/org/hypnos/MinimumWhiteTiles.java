package org.hypnos;


import java.util.Arrays;

/**
 * 2209. 用地毯覆盖后的最少白色砖块
 */
public class MinimumWhiteTiles {

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        int[][] memo = new int[numCarpets + 1][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(numCarpets, m - 1, floor.toCharArray(), memo, carpetLen);
    }

    private int dfs(int i, int j, char[] floor, int[][] memo, int carpetLen) {
        if (j < carpetLen * i) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = dfs(i, j - 1, floor, memo, carpetLen) + (floor[j] - '0');
        if (i > 0) {
            res = Math.min(res, dfs(i - 1, j - carpetLen, floor, memo, carpetLen));
        }
        return memo[i][j] = res;
    }

}
