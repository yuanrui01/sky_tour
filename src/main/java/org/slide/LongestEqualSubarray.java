package org.slide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. 找出最长等值子数组
 */
public class LongestEqualSubarray {


    public int longestEqualSubarray(List<Integer> nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int n = nums.size();
        int ans = 0;
        while (right < n) {
            map.merge(nums.get(right), 1, Integer::sum);
            max = Math.max(max, map.get(nums.get(right)));
            while (right -  left + 1 - max > k) {
                map.merge(nums.get(left), -1, Integer::sum);
                if (map.get(nums.get(left)) == 0) {
                    map.remove(nums.get(left));
                }
                left++;
            }
            ans = Math.max(ans, max);
            right++;
        }
        return ans;
    }
}
