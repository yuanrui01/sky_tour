package org.hypnos;

/**
 * 3304. 找出第 K 个字符 I
 */
public class KthCharacter {

    private static char[] s = new char[1000];

    static {
        int len = 1;
        s[0] = 'a';
        while (len < 500) {
            for (int i = 0; i < len; ++i) {
                s[len + i] = (char) ('a' + (s[i] - 'a' + 1) % 26);
            }
            len *= 2;
        }
    }

    public char kthCharacter(int k) {
        return s[k-1];
    }

    public static void main(String[] args) {
        KthCharacter kthCharacter = new KthCharacter();

        System.out.println(kthCharacter.kthCharacter(5));
        System.out.println(kthCharacter.kthCharacter(10));
    }
}
