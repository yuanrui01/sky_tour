package org.hypnos;


import java.util.Arrays;

/**
 * 2090. 半径为 k 的子数组平均值
 */
public class GetAverages {

    public int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        int windowsSize = 2 * k + 1;
        Arrays.fill(result, -1);
        if (nums.length >= windowsSize) {
            long sum = 0;
            for (int i = 0; i < windowsSize; i++) {
                sum += nums[i];
            }
            for (int i = k; i < nums.length - k; ++i) {
                result[i] = (int) (sum / windowsSize);
                if (i != nums.length - k - 1) {
                    sum -= nums[i - k];
                    sum += nums[i + k + 1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        int k  = 3;
        int[] averages = new GetAverages().getAverages(nums, k);
        System.out.println(Arrays.toString(averages));
    }
}
