package org.hypnos;


import java.util.Arrays;

/**
 * 2944. 购买水果需要的最少金币数
 */
public class MinimumCoins {

    /**
     * 给你一个 下标从 1 开始的 整数数组 prices ，其中 prices[i] 表示你购买第 i 个水果需要花费的金币数目。
     * 水果超市有如下促销活动：
     * 如果你花费 prices[i] 购买了下标为 i 的水果，那么你可以免费获得下标范围在 [i + 1, i + i] 的水果。
     * 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j] 个金币去购买它以获得它的奖励。
     * 请你返回获得所有水果所需要的 最少 金币数。
     */
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] memo = new int[(n + 1) / 2];
        return dp(prices, memo, 1);
    }

    private int dp(int[] prices, int[] memo, int i) {
        if (i * 2 >= prices.length) {
            return prices[i - 1];
        }
        if (memo[i] != 0) return memo[i];
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j <= 2 * i + 1; ++j) {
            res = Math.min(res, dp(prices, memo, j));
        }
        return memo[i] = res + prices[i-1];
    }

    /**
     * 递推写法
     */
    public int minimumCoins2(int[] f) {
        int n = f.length;
        for (int i = (n + 1) / 2 - 1; i > 0; --i) {
            int res = Integer.MAX_VALUE;
            for (int j = i; j <= 2*i; ++j) {
                res = Math.min(res, f[j]);
            }
            f[i-1] += res;
        }
        return f[0];
    }
    public static void main(String[] args) {
        MinimumCoins minimumCoins = new MinimumCoins();
        int[] prices = {1,37,19,38,11,42,18,33,6,37,15,48,23,12,41,18,27,32};
        System.out.println(minimumCoins.minimumCoins(prices));
    }
}
