package org.hypnos;

import java.util.HashMap;
import java.util.Map;


/**
 * 76. 最小覆盖子串
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Integer> tMode = new HashMap<>();
        int n = s.length();
        int m = t.length();
        String ans = "";
        if (n < m)
            return ans;
        for (char c : tArr)
            tMode.merge(c, 1, Integer::sum);
        int left = 0, right = 0;
        int count = 0;
        int minCount = Integer.MAX_VALUE;
        Map<Character, Integer> curMode = new HashMap<>();
        while (right < n) {
            count++;
            curMode.merge(sArr[right], 1, Integer::sum);
            while (check(tMode, curMode)) {
                if (count < minCount) {
                    minCount = Math.min(count, minCount);
                    ans = s.substring(left, right + 1);
                }
                count--;
                curMode.merge(sArr[left++], -1, Integer::sum);
            }
            right++;
        }
        return ans;
    }

    private boolean check(Map<Character, Integer> targetMode, Map<Character, Integer> curMode) {
        for (Map.Entry<Character, Integer> entry : targetMode.entrySet()) {
            if (curMode.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s, t));
    }
}
