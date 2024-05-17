package org.hypnos;

import java.util.HashMap;
import java.util.Map;


/**
 * 2266. 统计打字方案数
 */
public class CountTexts {

    private static final int LIMIT = 1000000007;
    // 存储每个按键对应的字符数
    private static final int[] phoneMap = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
    // 丐版缓存
    private static final Map<Integer, long[]> numCache = new HashMap<>();

    public int countTexts(String pressedKeys) {
        long ans = 1L;
        int charTotal = pressedKeys.length();
        int i = 0;
        while (i < charTotal) {
            int processNum = pressedKeys.charAt(i) - '0';
            int count = 1;
            while (i + 1 < charTotal && (pressedKeys.charAt(i + 1) - '0') == processNum) {
                i++;
                count++;
            }
            ans = (ans * dp(processNum, count)) % LIMIT;
            ++i;
        }

        return (int) ans;
    }

    private long dp(int target, int count) {
        if (numCache.get(target) != null && numCache.get(target).length > count + 1)
            return numCache.get(target)[count];
        long[] memo = new long[count + 1];
        int loops = phoneMap[target];
        memo[0] = 1L;
        int i = 1;
        if (numCache.get(target) != null) {
            i = numCache.get(target).length;
            System.arraycopy(numCache.get(target), 0, memo, 0, i);
        }
        while (i <= count) {
            for (int j = 1; j <= loops; ++j) {
                if (i - j >= 0)
                    memo[i] = (memo[i] + memo[i - j]) % LIMIT;
            }
            ++i;
        }
        numCache.put(target, memo);
        return memo[count];
    }


    public static void main(String[] args) {
        String processKeys = "222222222222222222222222222222222222";
        CountTexts countTexts = new CountTexts();
        System.out.println(countTexts.countTexts(processKeys));
    }
}
