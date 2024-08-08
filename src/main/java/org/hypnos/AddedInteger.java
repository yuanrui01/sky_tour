package org.hypnos;


/**
 * 3131. 找出与数组相加的整数 I
 */
public class AddedInteger {
    public int addedInteger(int[] nums1, int[] nums2) {
        return min(nums2) - min(nums1);
    }

    private int min(int[] a) {
        int min = 1001;
        for (int i : a) {
            min = Math.min(i, min);
        }
        return min;
    }
}
