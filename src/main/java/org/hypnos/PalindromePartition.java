package org.hypnos;

import java.util.Arrays;

/**
 * 1278. 分割回文串 III
 */
public class PalindromePartition {

    public int palindromePartition(String s, int k) {
        int n = s.length();
        if (n == k) return 0;
        int[][] memoChange = new int[n][n];
        for (int[] row : memoChange) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        int[][] memoDfs = new int[k][n];
        for (int[] row : memoDfs) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(k - 1, n - 1, s.toCharArray(), memoDfs, memoChange);
    }

    // 把 s[:r+1] 切 i 刀，分成 i+1 个子串，每个子串改成回文串的最小总修改次数
    private int dfs(int i, int r, char[] s, int[][] memoDfs, int[][] memoChange) {
        if (i == 0) { // 只有一个子串
            return minChange(0, r, s, memoChange);
        }
        if (memoDfs[i][r] != -1) { // 之前计算过
            return memoDfs[i][r];
        }
        int res = Integer.MAX_VALUE;
        // 枚举子串左端点 l
        for (int l = i; l <= r; l++) {
            res = Math.min(res, dfs(i - 1, l - 1, s, memoDfs, memoChange) + minChange(l, r, s, memoChange));
        }
        return memoDfs[i][r] = res; // 记忆化
    }

    // 把 s[i:j+1] 改成回文串的最小修改次数
    private int minChange(int i, int j, char[] s, int[][] memoChange) {
        if (i >= j) { // 子串只有一个字母，或者子串是空串
            return 0; // 无需修改
        }
        if (memoChange[i][j] != -1) { // 之前计算过
            return memoChange[i][j];
        }
        int res = minChange(i + 1, j - 1, s, memoChange);
        if (s[i] != s[j]) {
            res++;
        }
        return memoChange[i][j] = res; // 记忆化
    }
}
