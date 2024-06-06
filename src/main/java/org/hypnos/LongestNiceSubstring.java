package org.hypnos;


/**
 * 1763. 最长的美好子字符串
 */
public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        char[] charArray = s.toCharArray();
        int n = s.length();
        for (int i = n; i >= 2; --i) {
            int[] mode = new int[52];
            StringBuilder sb = new StringBuilder();
            String res = "";
            for (int j = n - 1; j >= n - i; --j) {
                setMode(mode, charArray[j], 1);
                sb.append(charArray[j]);
            }
            if (checkMode(mode)) {
                res = sb.reverse().toString();
            }
            for (int j = n - i - 1; j >= 0; --j) {
                setMode(mode, charArray[j], 1);
                setMode(mode, charArray[j + i], -1);
                sb.append(charArray[j]);
                sb.delete(0,1);
                if (checkMode(mode)) {
                    res = sb.reverse().toString();
                }
            }
            if (!res.isEmpty())
                return res;
        }
        return "";
    }

    private void setMode(int[] mode, char c, int inc) {
        if (c <= 'Z')
            mode[c - 'A'] += inc;
        else
            mode[c - 'a' + 26] += inc;
    }

    private boolean checkMode(int[] mode) {
        for (int i = 0; i < 26; ++i) {
            if (mode[i] > 0 && mode[i + 26] == 0) {
                return false;
            }
        }
        for (int i = 26; i < 52; ++i) {
            if (mode[i] > 0 && mode[i - 26] ==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "Bb";

        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();

        System.out.println(longestNiceSubstring.longestNiceSubstring(s));
    }
}
