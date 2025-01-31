package org.hypnos;


/**
 * 541. 反转字符串 II
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int k2 = 2 * k;
        int n = s.length();
        while (index + k2 < n) {
            int rk = k;
            while (rk > 0) {
                sb.append(s.charAt(index + rk - 1));
                rk--;
            }
            while (rk < k) {
                sb.append(s.charAt(index + k + rk));
                rk++;
            }
            index += k2;
        }
        if (index < n) {
            int rk = Math.min(k, n - index);
            while (rk > 0) {
                sb.append(s.charAt(index + rk - 1));
                rk--;
            }
            index += Math.min(k, n - index);
        }
        while (index < n) {
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr.reverseStr(s, k));
    }
}
