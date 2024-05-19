package org.hypnos;


/**
 * LCR 166. 珠宝的最高价值 - 空间优化
 */
public class JewelleryValue {

    public int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;
        int[] memo = new int[n + 1];
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                memo[j] = Math.max(memo[j], memo[j - 1]) + frame[i - 1][j - 1];
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int[][] frame = {{1,3,1},{1,5,1},{4,2,1}};
        JewelleryValue jewelleryValue = new JewelleryValue();
        System.out.println(jewelleryValue.jewelleryValue(frame));
    }
}
