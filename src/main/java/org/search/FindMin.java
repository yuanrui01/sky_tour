package org.search;


/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int last = nums[right];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= last) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
