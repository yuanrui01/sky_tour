package org.hypnos;


/**
 * LCR 166. 珠宝的最高价值 - 空间优化
 */
public class JewelleryValue {

    /**
     * 原址修改
     */
    public int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;
        for (int j = 1; j < n; ++j) {
            frame[0][j] += frame[0][j - 1];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                frame[0][j] = Math.max(frame[0][j], (j - 1) < 0 ? 0 : frame[0][j - 1]) + frame[i][j];
            }
        }
        return frame[0][n - 1];
    }

    public static void main(String[] args) {
        int[][] frame = {{1,3,1},{1,5,1},{4,2,1}};
        JewelleryValue jewelleryValue = new JewelleryValue();
        System.out.println(jewelleryValue.jewelleryValue(frame));
    }
}
