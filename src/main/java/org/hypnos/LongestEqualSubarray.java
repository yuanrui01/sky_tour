package org.hypnos;

import java.util.*;

/**
 * 2831. 找出最长等值子数组
 */
public class LongestEqualSubarray {

    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int n = nums.size();
        int ans = 0;
        int left = 0, right = 0;
        while (right < n) {
            Integer numRight = nums.get(right);
            map.merge(numRight, 1, Integer::sum);
            maxFrequency = Math.max(maxFrequency, map.get(numRight));
            while ((right - left + 1) - maxFrequency > k) {
                map.merge(nums.get(left), -1, Integer::sum);
                if (map.get(nums.get(left)) == 0)
                    map.remove(nums.get(left));
                left++;
            }
            ans = Math.max(ans, maxFrequency);
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,1,2,2,1,1);
        int k = 2;

        LongestEqualSubarray longestEqualSubarray = new LongestEqualSubarray();

        System.out.println(longestEqualSubarray.longestEqualSubarray(nums, k));
    }
}
