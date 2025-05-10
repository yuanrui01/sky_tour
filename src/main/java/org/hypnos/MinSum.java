package org.hypnos;


/**
 * 2918. 数组的最小相等和
 */
public class MinSum {

    public long minSum(int[] nums1, int[] nums2) {
        long[] rs1 = new long[2];
        long[] rs2 = new long[2];
        for (int n : nums1) {
            rs1[0] += n;
            if (n == 0) rs1[1]++;
        }
        for (int n : nums2) {
            rs2[0] += n;
            if (n == 0) rs2[1]++;
        }
        long minS1 = rs1[0] + rs1[1];
        long minS2 = rs2[0] + rs2[1];
        if (minS2 == minS1) return minS2;
        if (minS2 > minS1 && rs1[1] > 0) return minS2;
        if (minS1 > minS2 && rs2[1] > 0) return minS1;
        return -1;
    }

    public static void main(String[] args) {
        MinSum minSum = new MinSum();

    }
}
