package org.hypnos;


import java.util.Arrays;

/**
 * 1283. 使结果不超过阈值的最小除数
 */
public class SmallestDivisor {

    private int[] nums;

    public int smallestDivisor(int[] nums, int threshold) {
        this.nums = nums;
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(num, right);
        }


        while ( left <= right ) {
            int mid = left + (right - left) / 2;
            long sum = getSum(mid);
            if (sum > threshold)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    private long getSum(int divisor) {
        long ans = 0;
        for (int num : nums) {
            ans += num / divisor;
            if (num % divisor != 0)
                ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        SmallestDivisor smallestDivisor = new SmallestDivisor();
        int[] nums = {2,3,5,7,11};
        int threshold = 11;
        System.out.println(smallestDivisor.smallestDivisor(nums, threshold));
    }
}
