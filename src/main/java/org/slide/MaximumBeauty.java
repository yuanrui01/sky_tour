package org.slide;

import java.util.Arrays;

public class MaximumBeauty {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0, right = 0;
        int n = nums.length;
        int cmp = 2 * k;
        while (right < n) {
            while (nums[right] - nums[left] > cmp) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
