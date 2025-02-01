package org.search;


/**
 * 33. 搜索旋转排序数组
 */
public class RotateSortingArray {


    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int last = nums[n-1];
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            int nm = nums[mid];
            if (nm == target) {
                return mid;
            }
            if (nm > last) {
                if (target > last && nm > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > last || nm > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotateSortingArray rotateSortingArray = new RotateSortingArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(rotateSortingArray.search(nums, target));
    }
}
