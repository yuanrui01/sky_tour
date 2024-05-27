package org.hypnos;


/**
 * 1456. 定长子串中元音的最大数目
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        char[] cArr = s.toCharArray();
        int kWindowCount = 0;
        for (int i = 0; i < k; ++i)
            if (isVowel(cArr[i]))
                kWindowCount++;

        int ans = kWindowCount;
        for (int i = k; i < s.length(); ++i) {
            if (isVowel(cArr[i]))
                kWindowCount++;
            if (isVowel(cArr[i - k]))
                kWindowCount--;
            ans = Math.max(ans, kWindowCount);
        }
        return ans;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
