package org.slide;


/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class LongestSubarray {

    // 0 0 1 1 1 0 0
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int left = 0, right = 0;
        int zi = -1;
        while (right < nums.length) {
            if (nums[right] == 0) {
                left = Math.max(left, zi + 1);
                zi = right;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans - 1;
    }
}
