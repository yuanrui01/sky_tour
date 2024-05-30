package org.hypnos;

/**
 * 1100. 长度为 K 的无重复字符子串
 */
public class NumKLenSubstrNoRepeats {

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k)
            return 0;
        if (k > 26)
            return 0;
        int ans = 0;
        int[] charCount = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < k; ++i)
            charCount[arr[i] - 'a']++;
        if (isNoRepeats(charCount))
            ans++;
        for (int i = k ; i < s.length(); ++i) {
            charCount[arr[i] - 'a']++;
            charCount[arr[i - k] - 'a']--;
            if (isNoRepeats(charCount))
                ans++;
        }
        return ans;
    }


    private boolean isNoRepeats(int[] charCount) {
        for (int i : charCount)
            if (i > 1)
                return false;
        return true;
    }
}
