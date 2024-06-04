package org.hypnos;


/**
 * 2401. 最长优雅子数组
 * 给你一个由 正 整数组成的数组 nums 。
 * 如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。
 * 返回 最长 的优雅子数组的长度。
 * 子数组 是数组中的一个 连续 部分。
 * 注意：长度为 1 的子数组始终视作优雅子数组。
 */
public class LongestNiceSubarray {

    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int orRes = 0;
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            while ((orRes & nums[right]) != 0) {
                orRes ^= nums[left];
                left++;
            }
            orRes |= nums[right];
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,11,13};
        LongestNiceSubarray longestNiceSubarray = new LongestNiceSubarray();
        System.out.println(longestNiceSubarray.longestNiceSubarray(nums));
    }
}
