package org.slide;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2799. 统计完全子数组的数目
 */
public class CountCompleteSubarrays {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> total = new HashSet<>();
        for (int num : nums)
            total.add(num);
        int ts = total.size();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.size() == ts) {
                int x = nums[left++];
                map.merge(x, -1, Integer::sum);
                if (map.get(x) == 0)
                    map.remove(x);
            }
            ans += left;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,2};
        CountCompleteSubarrays countCompleteSubarrays = new CountCompleteSubarrays();

        System.out.println(countCompleteSubarrays.countCompleteSubarrays(nums));
    }
}
