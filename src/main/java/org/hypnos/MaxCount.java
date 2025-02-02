package org.hypnos;


/**
 * 598. Range Addition II
 */
public class MaxCount {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m*n;
        // 更新最小值
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for (int[] op : ops) {
            x = Math.min(op[0], x);
            y = Math.min(op[1], y);
        }
        return x * y;
    }
}
