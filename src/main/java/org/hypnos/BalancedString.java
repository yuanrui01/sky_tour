package org.hypnos;

import java.util.HashMap;
import java.util.Map;


/**
 * 1234. 替换子串得到平衡字符串
 */
class BalancedString {

    public int balancedString(String s) {
        char[] pattern = new char[]{'Q', 'W', 'E', 'R'};
        char[] arr = s.toCharArray();
        Map<Character, Integer> sMode = new HashMap<>();
        int n = s.length();
        int singleCount = n / 4;
        for (char c : arr)
            sMode.merge(c, 1, Integer::sum);
        Map<Character, Integer> targetMode = new HashMap<>();
        for (char c : pattern) {
            Integer sVal = sMode.getOrDefault(c, 0);
            if (sVal > singleCount) {
                targetMode.put(c, sVal - singleCount);
            }
        }
        if (targetMode.isEmpty())
            return 0;
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        Map<Character, Integer> curMode = new HashMap<>();
        while (right < n) {
            curMode.merge(arr[right], 1, Integer::sum);
            while (check(targetMode, curMode)) {
                ans = Math.min(ans, right - left + 1);
                curMode.merge(arr[left++], -1, Integer::sum);
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
        String s = "QQWE";
        BalancedString balancedString = new BalancedString();
        System.out.println(balancedString.balancedString(s));
    }
}