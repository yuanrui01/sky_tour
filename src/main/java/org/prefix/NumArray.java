package org.prefix;


/**
 * 303. 区域和检索 - 数组不可变
 */
public class NumArray {

    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return nums[right] - ((left == 0) ? 0 : nums[left-1]);
    }
}
