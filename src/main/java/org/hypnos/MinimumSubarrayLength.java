package org.hypnos;

/**
 * 3097. 或值至少为 K 的最短子数组 II
 */
public class MinimumSubarrayLength {

    public static void main(String[] args) {
        MinimumSubarrayLength minimumSubarrayLength = new MinimumSubarrayLength();
        int[] nums = {1, 2};
        int k = 0;
        System.out.println(minimumSubarrayLength.minimumSubarrayLength(nums, k));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int length = nums.length;
        int[] bitCount = new int[31];
        while (right < length) {
            addBit(bitCount, nums[right]);
            while (left <= right && getNum(bitCount) >= k) {
                removeBit(bitCount, nums[left]);
                ans = Math.min(ans, right - left + 1);
                left++;
            }
            right++;
        }
        return Integer.MAX_VALUE == ans ? -1 : ans;
    }

    private void addBit(int[] bitCount, int num) {
        for (int i = 0; i < 31; ++i) {
            bitCount[i] += num & 1;
            num >>= 1;
        }
    }

    private void removeBit(int[] bitCount, int num) {
        for (int i = 0; i < 31; ++i) {
            bitCount[i] -= num & 1;
            num >>= 1;
        }
    }

    private int getNum(int[] bitCount) {
        int num = 0;
        int factor = 1;
        for (int i = 0; i < 31; ++i) {
            if (bitCount[i] > 0) {
                num += factor;
            }
            factor <<= 1;
        }
        return num;
    }
}
