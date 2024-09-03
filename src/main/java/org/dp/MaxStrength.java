package org.dp;


/**
 * 2708. 一个小组的最大实力值
 */
public class MaxStrength {

    public long maxStrength(int[] nums) {
        long min = nums[0];
        long max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            long x = nums[i];
            long tmp = min;
            min = Math.min(Math.min(min, x), Math.min(min * x, max * x));
            max = Math.max(Math.max(max, x), Math.max(tmp * x, max * x));
        }
        return max;
    }
}
