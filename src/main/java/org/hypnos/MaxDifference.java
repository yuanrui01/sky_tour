package org.hypnos;


/**
 * 3442. 奇偶频次间的最大差值 I
 */
public class MaxDifference {

    public int maxDifference(String S) {
        int[] counts = new int[26];
        char[] s = S.toCharArray();
        for (char c : s) {
            counts[c-'a']++;
        }
        int odd = 0;
        int even = 101;
        for (int count : counts) {
            if (count > 0) {
                if ((count & 1) == 1) {
                    odd = Math.max(odd, count);
                } else {
                    even = Math.min(even, count);
                }
            }
        }
        return odd-even;
    }

    public static void main(String[] args) {
        MaxDifference maxDifference = new MaxDifference();
        System.out.println(maxDifference.maxDifference("mmsmsym"));
    }
}
