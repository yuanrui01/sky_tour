package org.hypnos;


/**
 * 2145. 统计隐藏数组数目
 */
public class NumberOfArrays {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long s = 0, minS = 0, maxS = 0; // s[0] = 0
        for (int d : differences) {
            s += d;
            minS = Math.min(minS, s);
            maxS = Math.max(maxS, s);
        }
        return (int) Math.max(upper - lower - maxS + minS + 1, 0);
    }
}
