package org.hypnos;


/**
 * 198. 打家劫舍
 */
public class Rob {

    private int[] nums;

    public int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {2,7,9,3,1};
        System.out.println(rob.rob(nums));
    }
}
