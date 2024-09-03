package org.slide;

import java.util.Arrays;

public class MaxFrequency {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = nums.length - 1;
        int right = left;
        int ans = 0;
        int resume = k;
        while (left >= 0) {
            resume -= (nums[right] - nums[left]);
            while (resume < 0) {
                int diff = nums[right] - nums[right - 1];
                resume += diff * (right - left);
                right--;
            }
            ans = Math.max(ans, right - left + 1);
            left--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;
        MaxFrequency maxFrequency = new MaxFrequency();
        System.out.println(maxFrequency.maxFrequency(nums, k));
    }
}
