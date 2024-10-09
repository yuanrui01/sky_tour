package org.hypnos;


/**
 * 3171. 找到按位或最接近 K 的子数组
 */
public class MinimumDifference2 {


    /**
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     * 1 <= k <= 10^9
     */
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int[] digits = new int[32];
        while (right < n) {
            alterDigits(digits, nums[right], 1);
            ans = Math.min(ans, Math.abs(k - getNum(digits)));
            while (left < right && getNum(digits) > k) {
                alterDigits(digits, nums[left], -1);
                ans = Math.min(ans, Math.abs(k - getNum(digits)));
                left++;
            }
            right++;
        }
        return ans;
    }

    private void alterDigits(int[] digits, int n, int flag) {
        int i = 0;
        while (n != 0) {
            digits[i++] += flag * (n % 2);
            n >>= 1;
        }
    }

    private int getNum(int[] digits) {
        int sum = 0;
        int fact = 1;
        for (int i = 0; i < 32; i++) {
            sum += fact * (digits[i] != 0 ? 1 : 0);
            fact <<= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5};
        int k = 10;
        MinimumDifference2 minimumDifference2 = new MinimumDifference2();
        System.out.println(minimumDifference2.minimumDifference(nums, k));
    }
}
