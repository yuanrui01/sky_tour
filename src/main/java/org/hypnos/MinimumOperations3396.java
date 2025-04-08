package org.hypnos;


import java.util.HashSet;
import java.util.Set;

/**
 * 3396. 使数组元素互不相同所需的最少操作次数
 */
public class MinimumOperations3396 {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (!set.add(nums[i])) {
                return i / 3 + 1;
            }
        }
        return 0;
    }
}
