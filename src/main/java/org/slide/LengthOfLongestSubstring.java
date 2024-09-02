package org.slide;


import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) return 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        while (right < arr.length) {
            Integer idx = map.getOrDefault(arr[right], -1);
            left = Math.max(left, idx + 1);
            ans = Math.max(ans, right - left + 1);
            map.put(arr[right], right);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();

        String s = "au";
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
