package org.hypnos;


/**
 * 213. 打家劫舍 II
 */
public class Rob2 {

    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(dp(nums, 0, nums.length - 1), dp(nums, 1, nums.length));
    }

    public int dp(int[] nums, int begin, int end) {
        int f0 = 0, f1 = 0;
        for (int i = begin; i < end; ++i) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
