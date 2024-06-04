package org.hypnos;


import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 */
public class MaxFrequency {


    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = n - 1, right = n - 1;
        int ans = 1;
        int tmpSum = 0;
        while (left >= 0) {
            tmpSum += (nums[right] - nums[left]);
            if (tmpSum > k) {
                tmpSum -= (right - left) * (nums[right] - nums[right - 1]);
                right--;
            }
            ans = Math.max(ans, right - left + 1);
            left--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,9,6};
        int k = 2;
        MaxFrequency maxFrequency = new MaxFrequency();
        System.out.println(maxFrequency.maxFrequency(nums, k));
    }
}
