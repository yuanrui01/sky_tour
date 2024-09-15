package org.contest;

public class Case2024091501 {

    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for (int num : nums) {
            count[num]++;
        }
        int[] result = new int[2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] == 2) {
                result[index++] = i;
                if (index == 2) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
