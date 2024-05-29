package org.hypnos;

import java.util.ArrayList;
import java.util.List;


/**
 * 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (sLen < pLen) return ans;
        int[] sChars = new int[26];
        int[] pChars = new int[26];
        for (int i = 0; i < pLen; i++) {
            pChars[p.charAt(i) - 'a']++;
            sChars[s.charAt(i) - 'a']++;
        }
        if (isAnagrams(sChars, pChars)) {
            ans.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            sChars[s.charAt(i) - 'a']++;
            sChars[s.charAt(i - pLen) - 'a']--;
            if (isAnagrams(sChars, pChars)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }

    private boolean isAnagrams(int[] sChars, int[] pChars) {
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != pChars[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams(s, p));
    }
}
