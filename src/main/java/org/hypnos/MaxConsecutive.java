package org.hypnos;


import java.util.Arrays;

/**
 * 2274. 不含特殊楼层的最大连续楼层数
 */
public class MaxConsecutive {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int len = special.length;
        int ans = special[0] - bottom;
        ans = Math.max(ans, top - special[len - 1]);
        for (int i = 0; i < len - 1; ++i) {
            ans = Math.max(ans, special[i + 1] - special[i] - 1);
        }
        return ans;
    }
}
