package org.hypnos;


/**
 * 2269. 找到一个数字的 K 美丽值
 */
public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int ans = 0;
        for (int i = 0; i <= numStr.length() - k; i++) {
            int subNum = Integer.parseInt(numStr.substring(i, k));
            if (subNum == 0)
                continue;
            if (num % subNum == 0) {
                ans++;
            }
        }
        return ans;
    }
}
