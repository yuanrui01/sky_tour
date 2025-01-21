package org.hypnos;


import java.util.List;

/**
 * 2218. 从栈中取出 K 个硬币的最大面值和
 */
public class MaxValueOfCoins {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] memo = new int[n][k+1];
        return dfs(n - 1, k, piles, memo);
    }

    private int dfs(int i, int j, List<List<Integer>> piles, int[][] memo) {
        if (i < 0) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int res = dfs(i - 1, j, piles, memo);
        int v = 0;
        int limit = Math.min(j, piles.get(i).size());
        for (int w = 0; w < limit; ++w) {
            v += piles.get(i).get(w);
            res = Math.max(res, dfs(i - 1, j - w - 1, piles, memo) + v);
        }
        return memo[i][j] = res;
    }

    public static void main(String[] args) {
        List<List<Integer>> piles = List.of(List.of(1,100,3), List.of(7,8,9));
        int k = 2;
        MaxValueOfCoins maxValueOfCoins = new MaxValueOfCoins();
        System.out.println(maxValueOfCoins.maxValueOfCoins(piles, k));
    }
}
