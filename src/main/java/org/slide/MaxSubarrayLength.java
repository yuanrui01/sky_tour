package org.slide;

import java.util.HashMap;
import java.util.Map;


/**
 * 2958. 最多 K 个重复元素的最长子数组
 */
public class MaxSubarrayLength {

    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.get(nums[right]) > k) {
                map.merge(nums[left], -1, Integer::sum);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
