package org.hypnos;


/**
 * 3152. 特殊数组 II
 */
public class IsArraySpecial2 {


    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] preSum = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            preSum[i] = preSum[i - 1] + (nums[i] % 2 == nums[i - 1] % 2 ? 1 : 0);
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int[] q = queries[i];
            ans[i] = preSum[q[0]] == preSum[q[1]];
        }
        return ans;
    }
}
