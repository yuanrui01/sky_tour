package org.slide;

/**
 * 2134. 最少交换次数来组合所有的 1 II
 */
public class MinSwaps2 {

    public int minSwaps(int[] nums) {
        int zerosCount = 0;
        int onesCount = 0;
        for (int num : nums) {
            if (num == 0)
                zerosCount++;
            else
                onesCount++;
        }
        int k;
        int e;
        if (zerosCount > onesCount) {
            k = zerosCount;
            e = 0;
        } else {
            k = onesCount;
            e = 1;
        }

        int eCount = 0;
        for (int i = 0; i < k; ++i) {
            if (nums[i] == e)
                eCount++;
        }
        int max = eCount;
        for (int i = k; i < nums.length + k; ++i) {
            if (nums[i - k] == e) {
                eCount--;
            }
            if (nums[i % nums.length] == e) {
                eCount++;
            }
            max = Math.max(max, eCount);
        }
        return k - max;
    }
}
