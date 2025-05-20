package org.hypnos;


/**
 * 3355. 零数组变换 I
 */
public class IsZeroArray {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            diff[query[0]]++;
            diff[query[1] + 1]--;
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > diff[i]) {
                return false;
            }
            diff[i + 1] += diff[i];
        }
        return true;
    }

    public static void main(String[] args) {
        IsZeroArray isZeroArray = new IsZeroArray();
        int[] nums = {7};
        int[][] queries = {{0,0}};
        System.out.println(isZeroArray.isZeroArray(nums, queries));
    }
}
