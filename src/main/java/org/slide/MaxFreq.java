package org.slide;

import java.util.*;


/**
 * 1297. 子串的最大出现次数
 */
public class MaxFreq {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] charArray = s.toCharArray();
        int len = s.length();
        int ans = 0;
        for (int w = minSize; w <= maxSize; ++w) {
            Map<String, Integer> map = new HashMap<>();
            if (w <= maxLetters) {
                for (int i = 0; i <= len - w; ++i) {
                    map.merge(s.substring(i, i + w), 1, Integer::sum);
                }
            } else {
                int[] letters = new int[26];
                for (int i = 0; i < w; ++i) {
                    letters[charArray[i] - 'a']++;
                }
                if (check(letters, maxLetters)) {
                    map.merge(s.substring(0,w), 1, Integer::sum);
                }
                for (int i = w; i < len; ++i) {
                    letters[charArray[i] - 'a']++;
                    letters[charArray[i - w] - 'a']--;
                    if (check(letters, maxLetters))
                        map.merge(s.substring(i - w + 1, i + 1), 1, Integer::sum);
                }
            }
            for (Integer value : map.values()) {
                ans = Math.max(ans, value);
            }
        }
        return ans;
    }

    private boolean check(int[] letters, int maxLetters) {
        int count = 0;
        for (int letter : letters) {
            if (letter > 0)
                count++;
        }
        return count <= maxLetters;
    }
}
