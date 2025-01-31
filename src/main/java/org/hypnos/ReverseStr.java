package org.hypnos;


/**
 * 541. 反转字符串 II
 */
public class ReverseStr {

    public String reverseStr(String S, int k) {
        int n = S.length();
        char[] s = S.toCharArray();
        int k2 = 2 * k;
        for (int i = 0; i < n; i += k2) {
            reverse(s, i, Math.min(i + k, n) - 1);
        }
        return new String(s);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char t = s[left];
            s[left++] = s[right];
            s[right--] = t;
        }
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr.reverseStr(s, k));
    }
}
