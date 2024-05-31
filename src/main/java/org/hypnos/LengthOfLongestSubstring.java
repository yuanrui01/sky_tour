package org.hypnos;

import java.util.HashMap;
import java.util.Map;


/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int left = 0;
        int right = 1; // 指向当前处理元素的下标
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);// 至少一个
        int ans = 1;// 至少一个
        while (right < n) {
            left = Math.max(left, map.getOrDefault(s.charAt(right), -1) + 1); // 两者取最大，思维测试用例：abba，对第二次a的判断
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String s = "abba";
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
