package org.hypnos;


/**
 * 567. 字符串的排列
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int window = s1.length();
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int[] s1Alpha = new int[26];
        for (char c : s1Arr) {
            s1Alpha[c - 'a']++;
        }
        int[] s2Alpha = new int[26];
        for (int i = 0; i < window; ++i) {
            s2Alpha[s2Arr[i] - 'a']++;
        }
        if (isArrange(s1Alpha, s2Alpha))
            return true;

        for (int i = window; i < s2Arr.length; ++i) {
            s2Alpha[s2Arr[i] - 'a']++;
            s2Alpha[s2Arr[i - window] - 'a']--;
            if (isArrange(s1Alpha, s2Alpha))
                return true;
        }

        return false;
    }

    private boolean isArrange(int[] s1Alpha, int[] s2Alpha) {
        for (int i = 0; i < s1Alpha.length; ++i) {
            if (s1Alpha[i] != s2Alpha[i])
                return false;
        }
        return true;
    }
}
