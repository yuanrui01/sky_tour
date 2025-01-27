package org.hypnos;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {

    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(0, nums, memo);
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (i == nums.length - 1) {
            return 0;
        }
        if (nums[i] == 0) return Integer.MAX_VALUE;
        if (memo[i] != -1) return memo[i];
        int mn = Integer.MAX_VALUE;
        int limit = Math.min(nums[i], nums.length - 1 - i);
        for (int s = 1; s <= limit; s++) {
            mn = Math.min(mn, dfs(i + s, nums, memo));
        }
        if (mn != Integer.MAX_VALUE) mn++;
        return memo[i] = mn;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(jump.jump(nums));
    }
}
