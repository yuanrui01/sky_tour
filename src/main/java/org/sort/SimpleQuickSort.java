package org.sort;

import java.util.Arrays;

/**
 * 极简快排
 */
public class SimpleQuickSort {

    public static void qSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int flag = nums[left + (right - left)/2];
        while (i < j) {
            while (nums[i] < flag) i++;
            while (nums[j] > flag) j--;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
			i++;
			j--;
        }
        qSort(nums, left, j);
        qSort(nums, i, right);
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,1};
        qSort(nums, 0, 3);
        System.out.printf(Arrays.toString(nums));
    }
}
