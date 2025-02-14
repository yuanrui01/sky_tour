package org.hypnos;


/**
 * 9. 回文数
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int l = 0;
        int[] arr = new int[12];
        while (x != 0) {
            arr[l++] = x % 10;
            x /= 10;
        }
        int mid = l / 2;
        for (int i = 0; i < mid; ++i) {
            if (arr[i] != arr[l-i-1]) return false;
        }
        return true;
    }
}
