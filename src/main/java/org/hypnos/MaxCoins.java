package org.hypnos;


import java.util.Arrays;

/**
 * 1561. 你可以获得的最大硬币数目
 */
public class MaxCoins {

    public int maxCoins(int[] piles) {
        int ans = 0;
        Arrays.sort(piles);
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }
        return ans;
    }
}
