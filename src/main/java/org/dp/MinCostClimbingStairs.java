package org.dp;


/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cst = {10, 15 ,20};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cst));
    }
}
