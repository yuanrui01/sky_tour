package org.hypnos;

import java.util.Arrays;

public class CountGoodStrings {

    private static final int LIMIT = 1000000007;
    private int[] memo;
    private int zero;
    private int one;

    // 5 10 11
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        this.zero = zero;
        this.one = one;

        Arrays.fill(memo, -1);
        long ans = 0L;
        dp(memo, high);
        for (int i = low; i <= high; ++i) {
            if (memo[i] != -1) {
                ans = (ans + memo[i]) % LIMIT;
            } else {
                System.out.println("happen " + i);
            }
        }
        return (int)ans;
    }


    private int dp(int[] memo, int target) {
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            return memo[target];
        }

        long res = 0;
        if (target - zero >= 0) {
            res = dp(memo, target - zero) % LIMIT;
        }
        if (target - one >= 0) {
            res = (dp(memo, target - one) + res) % LIMIT;
        }
        memo[target] = (int)res;
        return (int)res;
    }

    public static void main(String[] args) {
        CountGoodStrings countGoodStrings = new CountGoodStrings();
        int low = 50000;
        int high = 99999;
        int zero = 2;
        int one = 3;
        System.out.println(countGoodStrings.countGoodStrings(low, high, zero, one));
    }
}
