package org.dp;

/**
 * 3287. 求出数组中最大序列值
 */
class MaxValue {
    public int maxValue(int[] nums, int k) {
        final int MX = 1 << 7;
        int n = nums.length;
        boolean[][] suf = new boolean[n - k + 1][];
        boolean[][] f = new boolean[k + 1][MX];
        f[0][0] = true;

        for (int i = n - 1; i >= k; --i) {
            int v = nums[i];
            for (int j = Math.min(k - 1, n - 1 - i); j >= 0; j--) {
                for (int x = 0; x < MX; ++x) {
                    if (f[j][x]) {
                        f[j + 1][x | v] = true;
                    }
                }
            }
            if (i <= n - k) {
                suf[i] = f[k].clone();
            }
        }

        int ans = 0;
        f = new boolean[k + 1][MX];
        f[0][0] = true;
        for (int i = 0; i < n - k; ++i) {
            int v = nums[i];
            for (int j = Math.min(k - 1, i); j >= 0; j--) {
                for (int x = 0; x < MX; ++x) {
                    if (f[j][x]) {
                        f[j + 1][x | v] = true;
                    }
                }
            }
            if(i < k - 1) {
                continue;
            }

            for (int x = 0; x < MX; ++x) {
                if (f[k][x]) {
                    for (int y = 0; y < MX; ++y) {
                        if (suf[i + 1][y]) {
                            ans = Math.max(ans, x ^ y);
                        }
                    }
                }
            }
            if (ans == MX - 1) {
                return ans;
            }
        }
        return ans;
    }
}
