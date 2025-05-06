package org.hypnos;

import java.util.Arrays;

/**
 * 1920. 基于排列构建数组
 */
public class BuildArray {

    // ans[i] = nums[nums[i]]
    // 前：0, 2, 1, 5, 3, 4
    // 后：0, 1, 2, 4, 5, 3
    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            if (x < 0)
                continue;
            int cur = i;
            while (nums[cur] != i) {
                int nxt = nums[cur];
                nums[cur] = ~nums[nxt];
                cur = nxt;
            }
            nums[cur] = ~x;
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = ~nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        BuildArray buildArray = new BuildArray();
        int[] nums = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray.buildArray(nums)));
    }
}
