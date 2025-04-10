package org.hypnos;

import java.util.Arrays;


/**
 * 2999. 统计强大整数的数目
 */
public class NumberOfPowerfulInt {


    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = "0".repeat(n - low.length()) + low; // 补前导零，和 high 对齐
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0, true, true, low.toCharArray(), high.toCharArray(), limit, s.toCharArray(), memo);
    }

    private long dfs(int i, boolean limitLow, boolean limitHigh, char[] low, char[] high, int limit, char[] s, long[] memo) {
        if (i == high.length) {
            return 1;
        }

        if (!limitLow && !limitHigh && memo[i] != -1) {
            return memo[i]; // 之前计算过
        }

        // 第 i 个数位可以从 lo 枚举到 hi
        // 如果对数位还有其它约束，应当只在下面的 for 循环做限制，不应修改 lo 或 hi
        int lo = limitLow ? low[i] - '0' : 0;
        int hi = limitHigh ? high[i] - '0' : 9;

        long res = 0;
        if (i < high.length - s.length) { // 枚举这个数位填什么
            for (int d = lo; d <= Math.min(hi, limit); d++) {
                res += dfs(i + 1, limitLow && d == lo, limitHigh && d == hi, low, high, limit, s, memo);
            }
        } else { // 这个数位只能填 s[i-diff]
            int x = s[i - (high.length - s.length)] - '0';
            if (lo <= x && x <= hi) { // 题目保证 x <= limit，无需判断
                res = dfs(i + 1, limitLow && x == lo, limitHigh && x == hi, low, high, limit, s, memo);
            }
        }

        if (!limitLow && !limitHigh) {
            memo[i] = res; // 记忆化 (i,false,false)
        }
        return res;
    }
}
