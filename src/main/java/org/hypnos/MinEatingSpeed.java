package org.hypnos;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 */
public class MinEatingSpeed {

    private int[] piles;
    /**
     * Example 1:
     * Input: piles = [3,6,7,11], h = 8
     * Output: 4
     *
     * Example 2:
     * Input: piles = [30,11,23,4,20], h = 5
     * Output: 30
     *
     * Example 3:
     * Input: piles = [30,11,23,4,20], h = 6
     * Output: 23
     */
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        this.piles = piles;
        int left = 0;
        int right = piles.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int tmp_res = getConsumerTime(mid);
            if (tmp_res > h)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // 检查结果 piles[left]
        int tmp_res = getConsumerTime(left);
        if (tmp_res == h) {
            return piles[left];
        } else if (tmp_res > h) {
            return getFinalResult(piles[left], piles[left + 1], h);
        } else {
            return getFinalResult(left == 0 ? 1 : piles[left - 1], piles[left], h);
        }
    }

    private int getConsumerTime(int begin) {
        int tmp_res = begin;
        int t_k = piles[begin];
        for (int i = begin; i < piles.length; ++i) {
            tmp_res += piles[i] / t_k;
            if (piles[i] % t_k != 0)
                tmp_res++;
        }
        return tmp_res;
    }

    private int getFinalResult(int left, int right, int h) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long t_res = 0;
            for (int pile : piles) {
                t_res += pile / mid;
                if (pile % mid != 0)
                    t_res++;
            }
            if (t_res > h)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
