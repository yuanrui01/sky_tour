package org.slide;


/**
 * 713. 乘积小于 K 的子数组
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1;
        int n = nums.length;
        int ans = 0;
        int left = 0, right = 0;
        while (right < n) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            ans = ans + right - left + 1;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
