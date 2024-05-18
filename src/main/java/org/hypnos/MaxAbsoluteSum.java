package org.hypnos;


/**
 * 1749. 任意子数组和的绝对值的最大值
 */
public class MaxAbsoluteSum {

    public int maxAbsoluteSum(int[] nums) {
        int negativeAns = Integer.MAX_VALUE;
        int negativeSum = 0;
        int positiveAns = Integer.MIN_VALUE;
        int positiveSum = 0;

        for (int num : nums) {
            negativeSum += num;
            positiveSum += num;
            negativeAns = Math.min(negativeAns, negativeSum);
            positiveAns = Math.max(positiveAns, positiveSum);
            if (negativeSum > 0)
                negativeSum = 0;
            if (positiveSum < 0)
                positiveSum = 0;
        }

        return Math.max(positiveAns, Math.abs(negativeAns));
    }
}
