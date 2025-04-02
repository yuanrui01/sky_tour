package org.hypnos;


/**
 * 2873. 有序三元组中的最大值 I
 */
public class MaximumTripletValue {

    public long maximumTripletValue(int[] nums) {
        long ans = 0L;
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                if (nums[i] < nums[j]) continue;
                for (int k = j + 1; k < n; ++k) {
                    ans = Math.max(ans, ((long) nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return ans;
    }
}
