package org.hypnos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 2841. 几乎唯一子数组的最大和
 */
public class MaxSum {

    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        long tSum = 0;
        int differentCount = 0;
        for (int i = 0; i < k; ++i) {
            Integer iNum = nums.get(i);
            tSum += iNum;
            Integer iNumCount = countMap.getOrDefault(iNum, 0);
            if (iNumCount == 0)
                differentCount++;
            countMap.merge(iNum, 1, Integer::sum);
        }
        if (differentCount >= m)
            ans = tSum;
        for (int i = k; i < nums.size(); ++i) {
            Integer iNum = nums.get(i);
            tSum += iNum;
            tSum -= nums.get(i - k);
            Integer iNumCount = countMap.getOrDefault(iNum, 0);
            if (iNumCount == 0)
                differentCount++;
            countMap.merge(iNum, 1, Integer::sum);
            Integer preKCount = countMap.get(nums.get(i - k));
            countMap.put(nums.get(i - k), --preKCount);
            if (preKCount == 0)
                differentCount--;
            if (differentCount >= m)
                ans = Math.max(ans, tSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,1,2);
        int m = 1;
        int k = 1;

        MaxSum maxSum = new MaxSum();
        System.out.println(maxSum.maxSum(nums,m,k));
    }
}
