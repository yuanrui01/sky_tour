package org.hypnos;


/**
 * 3330. 找到初始输入字符串 I
 */
public class PossibleStringCount {

    public int possibleStringCount(String word) {
        int ans = 1;
        int n = word.length();
        if (n == 1) return ans;
        int i = 0;
        while (i < n) {
            int cnt = 1;
            char x = word.charAt(i);
            while (i + 1 < n && word.charAt(i+1) == x) {
                i++;
                cnt++;
            }
            ans += cnt - 1;
            i++;
        }
        return ans;
    }
}
