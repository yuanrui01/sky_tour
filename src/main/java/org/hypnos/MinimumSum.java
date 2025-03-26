package org.hypnos;


/**
 * 2829. k-avoiding 数组的最小总和
 */
public class MinimumSum {

    public int minimumSum(int n, int k) {
        if (k / 2 > n) {
            return n * (n + 1) / 2;
        }
        int i1 = k / 2;
        int ans = 0;
        ans += (i1 + 1) * i1 / 2;
        int i2 = (n - i1);
        if (i2 > 0) {
            ans += (i2 * (2 * k + i2 - 1)/2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        MinimumSum minimumSum = new MinimumSum();
        System.out.println(minimumSum.minimumSum(n, k));
    }
}
