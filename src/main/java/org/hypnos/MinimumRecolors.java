package org.hypnos;


/**
 * 2379. 得到 K 个黑块的最少涂色次数
 */
public class MinimumRecolors {

    public int minimumRecolors(String blocks, int k) {
        char[] charArray = blocks.toCharArray();
        int bCnt = 0;
        for (int i = 0; i < k; i++)
            if (charArray[i] == 'B') bCnt++;
        int maxBCnt = bCnt;
        for (int i = k; i < blocks.length(); i++) {
            if (charArray[i] == 'B') bCnt++;
            if (charArray[i - k] == 'B') bCnt--;
            maxBCnt = Math.max(maxBCnt, bCnt);
        }
        return k - maxBCnt;
    }
}
