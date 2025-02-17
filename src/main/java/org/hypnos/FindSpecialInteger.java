package org.hypnos;


/**
 * 1287. 有序数组中出现次数超过25%的元素
 */
public class FindSpecialInteger {

    // 1,2,3,4,5,6,7,8,9,10,11,12,12,12,12
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;
        int index = 0;
        while (index < n) {
            int num = arr[index];
            int count = 1;
            while (index + 1 < n && arr[index + 1] == num) {
                index++;
                count++;
            }
            if (count > threshold) {
                return num;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindSpecialInteger findSpecialInteger = new FindSpecialInteger();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,12,12,12};
        System.out.println(findSpecialInteger.findSpecialInteger(nums));
    }
}
