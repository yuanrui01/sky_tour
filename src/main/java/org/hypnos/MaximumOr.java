package org.hypnos;


/**
 * 2680. 最大或值
 */
public class MaximumOr {

    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            suf[i] = suf[i+1] | nums[i+1];
        }
        long ans = 0;
        int pre = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i]);
            pre |= nums[i];
        }
        return ans;
    }
}
