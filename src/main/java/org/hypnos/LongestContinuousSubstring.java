package org.hypnos;


/**
 * 2414. 最长的字母序连续子字符串的长度
 */
public class LongestContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        int ans = 1;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int index = 0;
        while (index < len) {
            int cnt = 1;
            while (index + 1 < len && arr[index] + 1 == arr[index + 1]) {
                index++;
                cnt++;
            }
            ans = Math.max(ans, cnt);
            index++;
        }
        return ans;
    }
}
