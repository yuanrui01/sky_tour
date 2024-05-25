package org.hypnos;


import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组 - 前缀和 + 哈希表
 */
public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> preSumCount = new HashMap<>();
        for (int num : nums) {
            preSumCount.put(sum, preSumCount.getOrDefault(sum, 0) + 1);
            sum += num;
            ans += preSumCount.getOrDefault(sum - goal, 0);
        }
        return ans;
    }
}
