package org.dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 * 
 * Problem: You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    
    /**
     * Bottom-up dynamic programming approach.
     * Time Complexity: O(amount * coins.length)
     * Space Complexity: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        // dp[i] represents the minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];
        
        // Initialize with a value larger than any possible result
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;
        
        // Fill the dp array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // Either use the current coin or don't use it
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still amount + 1, it means the amount cannot be made up
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    /**
     * Top-down approach with memoization.
     */
    public int coinChangeTopDown(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2); // Initialize with -2 to distinguish from -1 (impossible)
        return dfs(coins, amount, memo);
    }
    
    private int dfs(int[] coins, int remaining, int[] memo) {
        // Base cases
        if (remaining == 0) return 0;
        if (remaining < 0) return -1;
        if (memo[remaining] != -2) return memo[remaining];
        
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = dfs(coins, remaining - coin, memo);
            if (result != -1) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        
        memo[remaining] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[remaining];
    }
    
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        
        // Test case 1: coins = [1, 2, 5], amount = 11
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Bottom-up approach:");
        System.out.println("Minimum coins needed for amount " + amount1 + ": " + solution.coinChange(coins1, amount1));
        System.out.println("Top-down approach:");
        System.out.println("Minimum coins needed for amount " + amount1 + ": " + solution.coinChangeTopDown(coins1, amount1));
        
        // Test case 2: coins = [2], amount = 3
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("\nBottom-up approach:");
        System.out.println("Minimum coins needed for amount " + amount2 + ": " + solution.coinChange(coins2, amount2));
        System.out.println("Top-down approach:");
        System.out.println("Minimum coins needed for amount " + amount2 + ": " + solution.coinChangeTopDown(coins2, amount2));
        
        // Test case 3: coins = [1], amount = 0
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("\nBottom-up approach:");
        System.out.println("Minimum coins needed for amount " + amount3 + ": " + solution.coinChange(coins3, amount3));
        System.out.println("Top-down approach:");
        System.out.println("Minimum coins needed for amount " + amount3 + ": " + solution.coinChangeTopDown(coins3, amount3));
    }
}