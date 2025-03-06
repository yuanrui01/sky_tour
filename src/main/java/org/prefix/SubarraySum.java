package org.prefix;


import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i-1];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            int cnt = map.getOrDefault(num-k, 0);
            ans += cnt;
            map.merge(num, 1, Integer::sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(nums, k));
    }
}
