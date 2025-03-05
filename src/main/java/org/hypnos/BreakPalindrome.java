package org.hypnos;


/**
 * 1328. 破坏回文串
 */
public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;
        if (n == 1) return "";
        boolean isOdd = n % 2 == 1;
        int mid = n / 2;
        for (int i = 0; i < n; ++i) {
            if (isOdd && i == mid) continue;
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        s[n-1]++;
        return new String(s);
    }


    public static void main(String[] args) {

    }
}
