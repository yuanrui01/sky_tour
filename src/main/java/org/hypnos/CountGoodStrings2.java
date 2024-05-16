package org.hypnos;


/**
 * 2466. 统计构造好字符串的方案数
 */
public class CountGoodStrings2 {

    private static final int LIMIT = 1000000007;

    // 5 10 11
    public int countGoodStrings(int low, int high, int zero, int one) {
        long ans = 0;
        long[] memo = new long[high + 1];
        memo[0] = 1;
        for (int i = 1; i <= high; ++i) {
            long f1 = (i - zero >= 0) ? memo[i - zero] : 0;
            long f2 = (i - one >= 0) ? memo[i - one] : 0;
            memo[i] = (f1 + f2) % LIMIT;
            if (i >= low && i <= high)
                ans = (ans + memo[i]) % LIMIT;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        CountGoodStrings2 countGoodStrings = new CountGoodStrings2();
        int low = 2;
        int high = 3;
        int zero = 1;
        int one = 2;
        System.out.println(countGoodStrings.countGoodStrings(low, high, zero, one));
    }
}
