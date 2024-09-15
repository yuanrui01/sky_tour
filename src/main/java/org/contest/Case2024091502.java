package org.contest;

public class Case2024091502 {

    public long maxScore(int[] a, int[] b) {
        long[] dp = new long[4];
        for (int i = 0; i < 4; i++) {
            dp[i] = Long.MIN_VALUE;
        }
        for (int k : b) {
            for (int i = 3; i >= 0; i--) {
                if (i == 0) {
                    dp[i] = Math.max(dp[i], (long) a[i] * k);
                } else if (dp[i - 1] != Long.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - 1] + (long) a[i] * k);
                }
            }
        }
        return dp[3];
    }

    public static void main(String[] args) {

    }
}
