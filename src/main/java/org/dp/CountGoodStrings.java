package org.dp;


import java.util.Arrays;

/**
 * 2466. 统计构造好字符串的方案数
 */
public class CountGoodStrings {

    private static final int LIMIT = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] cache = new int[high + 1];
        Arrays.fill(cache, -1);
        int ans = 0;
        for (int i = low; i <= high; ++i) {
            ans = (ans + dfs(i, zero, one, cache)) % LIMIT;
        }
        return ans;
    }

    private int dfs(int i, int zero, int one, int[] cache) {
        if (i < 0) return 0;
        if (i == 0) return 1;
        if (cache[i] != -1) return cache[i];
        return cache[i] = (dfs(i - zero, zero, one, cache) + dfs(i - one, zero, one, cache)) % LIMIT;
    }

    public static void main(String[] args) {

    }
}
