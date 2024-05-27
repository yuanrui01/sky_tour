package org.hypnos;

import java.util.HashMap;
import java.util.Map;


/**
 * 2461. 长度为 K 子数组中的最大和
 */
public class MaximumSubarraySum2 {

    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        long tSum = 0;
        int differentCount = 0;
        for (int i = 0; i < k; ++i) {
            tSum += nums[i];
            //===========================
            Integer iNumCount = countMap.getOrDefault(nums[i], 0);
            if (iNumCount == 0)
                differentCount++;
            countMap.merge(nums[i], 1, Integer::sum);
        }
        //===========================
        if (differentCount == k)
            ans = tSum;
        //===========================
        for (int i = k; i < nums.length; ++i) {
            tSum += nums[i];
            tSum -= nums[i - k];
            //===========================
            Integer iNumCount = countMap.getOrDefault(nums[i], 0);
            if (iNumCount == 0)
                differentCount++;
            countMap.merge(nums[i], 1, Integer::sum);
            //===========================
            Integer preKCount = countMap.get(nums[i - k]);
            countMap.put(nums[i - k], --preKCount);
            if (preKCount == 0)
                differentCount--;
            //===========================
            if (differentCount  == k)
                ans = Math.max(ans, tSum);
        }
        return ans;
    }
}
