package org.hypnos;


import java.util.Arrays;

/**
 * 2275. 按位与结果大于零的最长组合
 */
public class LargestCombination {

    public int largestCombination(int[] candidates) {
        int[] cnt = new int[24];
        for (int candidate : candidates) {
            int num = candidate;
            int k = 0;
            while (num != 0) {
                cnt[k++] += num & 1;
                num >>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 24; ++i) {
            ans = Math.max(ans, cnt[i]);
        }
        return ans;
    }

//    public int largestCombination_bak(int[] candidates) {
//        int[] cnt = new int[24];
//        for (int candidate : candidates) {
//            int num = candidate;
//            for (int i = 0; num != 0 ; i++, num >>= 1) {
//                cnt[i] += num & 1;
//            }
//        }
//        return Arrays.stream(cnt).max().getAsInt();
//    }
}
