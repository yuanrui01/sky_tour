package org.hypnos;


/**
 * 2844. 生成特殊数字的最少操作
 */
public class MinimumOperations {

    // 00 25 50 75
    public int minimumOperations(String num) {
        int ans = Integer.MAX_VALUE;
        char[] charArray = num.toCharArray();
        int[][] arrs = {{0,0}, {2,5}, {5,0}, {7,5}};
        int n = num.length();

        for (int[] arr : arrs) {
            int i1 = arr[0];
            int i2 = arr[1];

            int i = n - 1;
            int cnt = 0;

            while (i >= 0 && (charArray[i] - '0') != i2) {
                cnt++;
                --i;
            }
            --i;
            while (i >= 0 && (charArray[i] - '0') != i1) {
                cnt++;
                --i;
            }

            if (i >= 0)
                ans = Math.min(ans, cnt);
        }
        int zeroCount = 0;
        for (int i = 0; i < n; ++i)
            if (charArray[i] == '0')
                zeroCount++;
        return Math.min(ans, n - zeroCount);

    }
}
