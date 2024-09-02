package org.slide;


/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int ans = 0;
        int left = 0, right = 0;
        int pre0 = -1;
        while (right < nums.length) {
            if (nums[right] == 0) {
                left = Math.max(left, pre0);
                pre0 = right;
            }
            ans = Math.max(ans, right - left + 1 + (pre0 == -1 ? 0 : -1));
            right++;
        }
        return pre0 == -1 && ans > 0 ? ans - 1 : ans;
    }
}
