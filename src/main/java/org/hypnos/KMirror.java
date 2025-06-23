package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2081. k 镜像数字的和
 */
public class KMirror {

    private static final int MAX_N = 30;
    private static final List<Long>[] ans = new ArrayList[10];
    private static boolean initialized = false;

    // 这样写比 static block 快
    private void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        Arrays.setAll(ans, i -> new ArrayList<>());
        for (int base = 1; ; base *= 10) {
            // 生成奇数长度回文数，例如 base = 10，生成的范围是 101 ~ 999
            for (int i = base; i < base * 10; i++) {
                long x = i;
                for (int t = i / 10; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                if (doPalindrome(x)) {
                    return;
                }
            }
            // 生成偶数长度回文数，例如 base = 10，生成的范围是 1001 ~ 9999
            for (int i = base; i < base * 10; i++) {
                long x = i;
                for (int t = i; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                if (doPalindrome(x)) {
                    return;
                }
            }
        }
    }

    private boolean doPalindrome(long x) {
        boolean done = true;
        for (int k = 2; k < 10; k++) {
            if (ans[k].size() < MAX_N && isKPalindrome(x, k)) {
                ans[k].add(x);
            }
            if (ans[k].size() < MAX_N) {
                done = false;
            }
        }
        if (!done) {
            return false;
        }

        for (int k = 2; k < 10; k++) {
            // 原地求前缀和
            List<Long> s = ans[k];
            for (int i = 1; i < MAX_N; i++) {
                s.set(i, s.get(i) + s.get(i - 1));
            }
        }
        return true;
    }

    // 力扣 9. 回文数
    private boolean isKPalindrome(long x, int k) {
        if (x % k == 0) {
            return false;
        }
        int rev = 0;
        while (rev < x / k) {
            rev = rev * k + (int) (x % k);
            x /= k;
        }
        return rev == x || rev == x / k;
    }

    public long kMirror(int k, int n) {
        init();
        return ans[k].get(n - 1);
    }
}
