package org.search;

public class RotateSortingArray2 {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return nums[0] == target;
        int last = nums[n-1];
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            int nm = nums[mid];
            if (nm == target) {
                return true;
            }
            if (nm == nums[left]) {
                left++;
            } else if (nm > last) {
                if (target > last && nm >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > last || nm >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[right] == target;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 5;
        RotateSortingArray2 rotateSortingArray2 = new RotateSortingArray2();
        System.out.println(rotateSortingArray2.search(nums, target));
    }
}
