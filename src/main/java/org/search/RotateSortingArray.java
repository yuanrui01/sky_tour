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


    // 找最小的做法
//    public int search(int[] nums, int target) {
//        int minIndex = findMin(nums);
//        int r1 = search(nums, 0, minIndex - 1, target);
//        if (r1 != -1) return r1;
//        return search(nums, minIndex, nums.length - 1, target);
//    }
//
//    private int search(int[] nums, int left, int right, int target) {
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) return mid;
//            else if (nums[mid] < target) left = mid + 1;
//            else right = mid -1;
//        }
//        return -1;
//    }
//
//    private int findMin(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        int last = nums[right];
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] <= last) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

    public static void main(String[] args) {
        RotateSortingArray rotateSortingArray = new RotateSortingArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(rotateSortingArray.search(nums, target));
    }
}
