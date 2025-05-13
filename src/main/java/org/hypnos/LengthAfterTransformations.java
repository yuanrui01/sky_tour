package org.hypnos;

import java.util.List;

/**
 * 3335. 字符串转换后的长度 I
 */
public class LengthAfterTransformations {

    public int lengthAfterTransformations(String s, int t) {
        List<Integer> nums = List.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2);
        return lengthAfterTransformations(s, t, nums);
    }

    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        final int SIZE = 26;

        int[][] f0 = new int[SIZE][1];
        for (int i = 0; i < SIZE; i++) {
            f0[i][0] = 1;
        }

        int[][] m = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            int c = nums.get(i);
            for (int j = i + 1; j <= i + c; j++) {
                m[i][j % SIZE] = 1;
            }
        }

        int[][] mt = powMul(m, t, f0);

        int[] cnt = new int[SIZE];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        long ans = 0;
        for (int i = 0; i < SIZE; i++) {
            ans += (long) mt[i][0] * cnt[i];
        }
        return (int) (ans % MOD);
    }

    // a^n * f0
    private int[][] powMul(int[][] a, int n, int[][] f0) {
        int[][] res = f0;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = mul(a, res);
            }
            a = mul(a, a);
            n >>= 1;
        }
        return res;
    }

    // 返回矩阵 a 和矩阵 b 相乘的结果
    private int[][] mul(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a[i].length; k++) {
                if (a[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < b[k].length; j++) {
                    c[i][j] = (int) ((c[i][j] + (long) a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        return c;
    }
}
