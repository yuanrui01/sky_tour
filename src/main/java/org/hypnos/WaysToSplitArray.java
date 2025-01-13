package org.hypnos;


/**
 * 2270. 分割数组的方案数
 */
public class WaysToSplitArray {

    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        int ans = 0;
        long sufSum = 0L;
        for (int i = len - 1; i >= 0; --i) {
            sufSum += nums[i];
            if (sum >= 2 * sufSum) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};
        WaysToSplitArray waysToSplitArray = new WaysToSplitArray();
        System.out.println(waysToSplitArray.waysToSplitArray(nums));
    }
}
