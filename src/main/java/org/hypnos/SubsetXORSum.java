package org.hypnos;

/**
 * 1863. 找出所有子集的异或总和再求和
 */
public class SubsetXORSum {

    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int x : nums) {
            or |= x;
        }
        return or << (nums.length - 1);
    }
}
