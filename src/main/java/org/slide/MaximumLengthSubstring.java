package org.slide;


import java.util.HashMap;
import java.util.Map;

/**
 * 3090. 每个字符最多出现两次的最长子字符串
 */
public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = 0;
        int ans = 0;
        Map<Character, int[]> map = new HashMap<>();
        while (right < arr.length) {
            int[] rStatus = map.get(arr[right]);
            if (rStatus != null) {
                if (rStatus[2] == 2) {
                    left = Math.max(left, rStatus[0] + 1);
                    rStatus[0] = rStatus[1];
                } else {
                    rStatus[2] = 2;
                }
                rStatus[1] = right;
                map.put(arr[right], rStatus);
            } else {
                map.put(arr[right], new int[]{right, right, 1});
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLengthSubstring maximumLengthSubstring = new MaximumLengthSubstring();
        String s = "bcbbbcba";
        System.out.println(maximumLengthSubstring.maximumLengthSubstring(s));
    }
}
