package org.hypnos;


import java.util.HashMap;
import java.util.Map;

/**
 * 159. 至多包含两个不同字符的最长子串
 */
public class LengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            map.merge(s.charAt(right), 1, Integer::sum);
            count++;
            if (map.size() > 2) {
                map.merge(s.charAt(left), -1, Integer::sum);
                if (map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
                count--;
                left++;
            }
            ans = Math.max(ans, count);
            right++;
        }
        return ans;
    }
}
