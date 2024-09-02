package org.slide;

import java.util.HashMap;
import java.util.Map;


/**
 * 1695. 删除子数组的最大得分
 */
public class MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int sum = 0;
        int left = 0, right = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.merge(nums[right], 1, Integer::sum);
            sum += nums[right];
            while (map.size() < right - left + 1) {
                sum -= nums[left];
                Integer li = map.get(nums[left]);
                if (li == 1)
                    map.remove(nums[left]);
                else
                    map.put(nums[left], li - 1);
                left++;
            }
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }
}
