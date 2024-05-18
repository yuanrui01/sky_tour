package org.hypnos;

/**
 * 53. 最大子数组和 - dp做法
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(sum, result);
            if (sum < 0)
                sum = 0;
        }
        return result;
    }
}
