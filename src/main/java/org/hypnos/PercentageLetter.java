package org.hypnos;


/**
 * 2278. 字母在字符串中的百分比
 */
public class PercentageLetter {

    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == letter) {
                cnt++;
            }
        }
        return (int) (100 * ((1.0 * cnt) / n));
    }

    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'o';
        PercentageLetter percentageLetter = new PercentageLetter();
        System.out.println(percentageLetter.percentageLetter(s, letter));
    }
}
