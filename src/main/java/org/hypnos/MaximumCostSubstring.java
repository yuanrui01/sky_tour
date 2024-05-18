package org.hypnos;


/**
 * 2606. 找到最大开销的子字符串
 */
public class MaximumCostSubstring {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] mapArr = new int[26];
        for (int i = 0; i < 26; i++) {
            mapArr[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); ++i) {
            int charIndex = chars.charAt(i) - 'a';
            mapArr[charIndex] = vals[i];
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            sum += mapArr[s.charAt(i) - 'a'];
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
