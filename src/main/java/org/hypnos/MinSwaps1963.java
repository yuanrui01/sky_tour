package org.hypnos;


/**
 * 1963. 使字符串平衡的最小交换次数
 */
public class MinSwaps1963 {

    // ] ] ] [ [ [
    public int minSwaps(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int c = 0;
        int j = s.length - 1;
        for (char b : s) {
            if (b == '[') {
                c++;
            } else if (c > 0) {
                c--;
            } else {
                while (s[j] == ']') {
                    j--;
                }
                s[j] = ']';
                ans++;
                c++;
            }
        }
        return ans;
    }
}
