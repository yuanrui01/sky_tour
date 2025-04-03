package org.hypnos;

/**
 * 2874. 有序三元组中的最大值 II
 */
public class MaximumTripletValue2 {

    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] rm = new int[n-2];
        rm[n-3] = nums[n - 1];
        int[] lm = new int[n-2];
        lm[0] = nums[0];
        for (int i = n - 2; i > 1; --i) {
            rm[i-2] = Math.max(rm[i-1], nums[i]);
        }
        for (int i = 1; i < n - 2; ++i) {
            lm[i] = Math.max(lm[i-1], nums[i]);
        }
        for (int i = 1; i < n - 1; ++i) {
            ans = Math.max(ans, ((long) lm[i-1] - nums[i]) * rm[i-1]);
        }
        return ans;
    }
}
