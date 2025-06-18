package org.hypnos;

import java.util.Arrays;


/**
 * 2966. 划分数组并满足最大差限制
 */
public class DivideArray {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n/3][];
        for (int i = 2, j = 0; i < n; i+=3, j++) {
            if (nums[i] - nums[i-2] > k) {
                return new int[][]{};
            }
            ans[j] = new int[]{nums[i-2], nums[i-1], nums[i]};
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,4,8,7,9,3,5,1};
        DivideArray divideArray = new DivideArray();
        int[][] ints = divideArray.divideArray(nums, 2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
//        Arrays.sort(nums);
//        // 1, 1, 3, 3, 4, 5, 7, 8, 9
//        System.out.println(Arrays.toString(nums));
    }
}
