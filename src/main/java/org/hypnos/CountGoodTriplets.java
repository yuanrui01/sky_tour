package org.hypnos;


/**
 * 1534. 统计好三元组
 */
public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    int iv = arr[i];
                    int jv = arr[j];
                    int kv = arr[k];
                    if (Math.abs(iv - jv) <= a && Math.abs(jv - kv) <= b && Math.abs(iv - kv) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
