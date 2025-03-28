package org.hypnos;


/**
 * 2716. 最小化字符串长度
 */
public class MinimizedStringLength {

    // baadccab
    // b a d c a b
    public int minimizedStringLength(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            ans |= (1 << (s.charAt(i) - 'a'));
        }
        return Integer.bitCount(ans);
    }
}
