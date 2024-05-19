package org.hypnos;


/**
 * 2321. 拼接数组的最大分数
 */
public class MaximumsSplicedArray {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int[] nums1SubNums2 = new int[nums1.length];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums1SubNums2[i] = nums1[i] - nums2[i];
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        int maxAns = 0;
        int maxSum = 0;
        int minAns = Integer.MAX_VALUE;
        int minSum = 0;
        for (int j : nums1SubNums2) {
            maxSum += j;
            minSum += j;
            maxAns = Math.max(maxAns, maxSum);
            minAns = Math.min(minAns, minSum);
            if (maxSum < 0)
                maxSum = 0;
            if (minSum > 0)
                minSum = 0;
        }
        return Math.max(sum2 + maxAns, sum1 - minAns);
    }

    public static void main(String[] args) {
        int[] nums1 = {7,11,13};
        int[] nums2 = {1,1,1};
        MaximumsSplicedArray maximumsSplicedArray = new MaximumsSplicedArray();
        System.out.println(maximumsSplicedArray.maximumsSplicedArray(nums1, nums2));
    }
}
