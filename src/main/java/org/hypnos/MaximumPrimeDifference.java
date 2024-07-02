package org.hypnos;

import java.util.Arrays;


/**
 * 3115. 质数的最大距离
 */
public class MaximumPrimeDifference {
    private static boolean[] isPrime;
    static {
        isPrime = new boolean[101];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i < 101; ++i)
            if (isPrime[i])
                for (int j = i * i; j < 101; j += i)
                    isPrime[j] = false;
    }
    public int maximumPrimeDifference(int[] nums) {
        int firstIndex = -1;
        int lastIndex = -1;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (isPrime[nums[i]]) {
                firstIndex = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if(isPrime[nums[i]]) {
                lastIndex = i;
                break;
            }
        }
        return lastIndex - firstIndex;
    }

    public static void main(String[] args) {
        MaximumPrimeDifference maximumPrimeDifference = new MaximumPrimeDifference();
        int[] nums = {4,2,9,5,3};
        System.out.println(maximumPrimeDifference.maximumPrimeDifference(nums));
    }
}
