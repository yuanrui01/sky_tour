package org.slide;


/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {


    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
