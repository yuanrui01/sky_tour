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
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = nums.stream().mapToInt(i -> i).toArray();
        long kSum = 0;
        for (int i = 0; i < k; ++i) {
            kSum += arr[i];
            map.merge(arr[i], 1, Integer::sum);
        }
        if (map.size() >= m) {
            ans = Math.max(ans, kSum);
        }
        for (int i = k; i < arr.length; ++i) {
            kSum -= arr[i - k];
            kSum += arr[i];
            map.merge(arr[i], 1, Integer::sum);
            Integer ik = map.get(arr[i - k]);
            if (ik == 1)
                map.remove(arr[i-k]);
            else
                map.put(arr[i-k], ik - 1);
            if (map.size() >= m)
                ans = Math.max(ans, kSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,1,2,1,2,1);
        int m = 3;
        int k = 3;

        MaxSum maxSum = new MaxSum();
        System.out.println(maxSum.maxSum(nums,m,k));
    }
}
