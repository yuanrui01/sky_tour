package org.hypnos;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
public class CanPartition {


    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (s % 2 != 0) {
            return false;
        }
        int[][] memo = new int[n][s/2 + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(n-1, s / 2, nums, memo);
    }

    private boolean dfs(int i, int j, int[] nums, int[][] memo) {
        if (i < 0) {
            return j == 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        boolean res = j >= nums[i] && dfs(i-1, j-nums[i], nums, memo) || dfs(i-1, j, nums, memo);
        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
