package org.hypnos;

import java.util.Arrays;


/**
 * 2294. 划分数组使最大差为 K
 */
public class PartitionArray {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int index = 0;
        int rem = k;
        while (index < n) {
            while (index + 1 < n && nums[index + 1] - nums[index] <= rem) {
                rem -= nums[index + 1] - nums[index];
                index++;
            }
            rem = k;
            ans++;
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,2,5};
        int k = 2;
        PartitionArray partitionArray = new PartitionArray();
        System.out.println(partitionArray.partitionArray(nums, k));
    }
}
