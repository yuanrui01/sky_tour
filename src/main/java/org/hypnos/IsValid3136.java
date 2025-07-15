package org.hypnos;


/**
 * 3136. 有效单词
 */
public class IsValid3136 {

    public boolean isValid(String word) {
        int len = word.length();
        if (len < 3) return false;
        word = word.toLowerCase();
        boolean[] f = new boolean[2];
        for (int i = 0; i < len; ++i) {
            char c = word.charAt(i);
            if (c == '@' || c == '#' || c == '$') {
                return false;
            }
            if (Character.isAlphabetic(c)) {
                f[c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 0 : 1] = true;
            }
        }
        return f[0] && f[1];
    }

    public static void main(String[] args) {
        IsValid3136 isValid3136 = new IsValid3136();
        String word = "UuE6";
        System.out.println(isValid3136.isValid(word));
    }
}
