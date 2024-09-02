package org.slide;


/**
 * 2730. 找到最长的半重复子字符串
 */
public class LongestSemiRepetitiveSubstring {

    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1;
        int left = 0, right = 0;
        char[] crr = s.toCharArray();
        int n = crr.length;
        int cnt = 0;
        while (right < n - 1) {
            if (crr[right] == crr[right + 1]) {
                cnt++;
            }
            while (cnt > 1) {
                if (crr[left] == crr[left + 1]) {
                    cnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 2);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSemiRepetitiveSubstring longestSemiRepetitiveSubstring = new LongestSemiRepetitiveSubstring();
        System.out.println(longestSemiRepetitiveSubstring.longestSemiRepetitiveSubstring("52233"));
    }
}
