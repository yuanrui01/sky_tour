package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer pre = map.get(nums[i]);
            if (pre != null && Math.abs(i - pre) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
