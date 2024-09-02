package org.slide;


/**
 * 1004. 最大连续1的个数 III
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0, right = 0;
        int kCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                kCount++;
            }
            while (kCount > k) {
                if (nums[left] == 0) {
                    kCount--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
