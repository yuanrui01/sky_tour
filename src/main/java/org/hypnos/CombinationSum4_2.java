package org.hypnos;

/**
 * 377. 组合总和 Ⅳ - 递推式
 **/
class CombinationSum4_2 {

    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for(int i = 1; i <= target; ++i) {
            for(int num : nums) {
                if (num <= i) {
                    f[i] += f[i - num];
                }
            }
        }
        return f[target];
    }

}