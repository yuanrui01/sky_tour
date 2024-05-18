package org.hypnos;


/**
 * 53. 最大子数组和 - 分治
 */
public class MaxSubArrayDivideAndConquer {

    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = left + (right - left) / 2;
        int maxSubResult = Math.max(divideAndConquer(nums, left, mid), divideAndConquer(nums, mid + 1, right));

        int tmpLeft = 0;
        int leftMax = 0;
        int tmpRight = 0;
        int rightMax = 0;
        for (int i = mid - 1; i >= 0; --i) {
            tmpLeft += nums[i];
            leftMax = Math.max(tmpLeft, leftMax);
        }

        for (int i = mid + 1; i <= right; ++i) {
            tmpRight += nums[i];
            rightMax = Math.max(tmpRight, rightMax);
        }
        return Math.max(maxSubResult, nums[mid] + leftMax + rightMax);
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();

        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
