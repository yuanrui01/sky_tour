package org.hypnos;

import java.util.Map;
import java.util.HashMap;

/**
 * 2588. 统计美丽子数组数目
 */
public class BeautifulSubarrays {

    public long beautifulSubarrays(int[] nums) {
        long ans = 0L;
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1);
        cnt.put(0, 1);
        for (int num : nums) {
            s ^= num;
            ans += cnt.getOrDefault(s, 0);
            cnt.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}
