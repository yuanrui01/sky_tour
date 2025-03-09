package org.hypnos;


/**
 * 2269. 找到一个数字的 K 美丽值
 */
public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int n = str.length();
        int ans = 0;
        for (int i = 0; i <= n - k; ++i) {
            int subNum = Integer.parseInt(str.substring(i, i+k));
            if (subNum == 0) continue;
            if ((num % subNum) == 0) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 240;
        int k = 2;
        DivisorSubstrings divisorSubstrings = new DivisorSubstrings();

        System.out.println(divisorSubstrings.divisorSubstrings(num, k));
    }
}
