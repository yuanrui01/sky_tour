package org.slide;


/**
 * 1208. 尽可能使字符串相等
 */
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        char[] srr = s.toCharArray();
        char[] trr = t.toCharArray();
        int n = srr.length;
        int left = 0, right = 0;
        int cost = 0;
        while (right < n) {
            cost += Math.abs(srr[right] - trr[right]);
            while (cost > maxCost) {
                cost -= Math.abs(srr[left] - trr[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
