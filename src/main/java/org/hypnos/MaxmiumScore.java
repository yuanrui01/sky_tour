package org.hypnos;


import java.util.Arrays;

/**
 * LCP 40. 心算挑战
 */
public class MaxmiumScore {

    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int s = 0;
        for (int i = n - cnt; i < n; ++i) {
            s += cards[i];
        }
        if (s % 2 == 0) {
            return s;
        }

        int x = cards[n - cnt];
        int ans = replaceSum(cards, cnt, s, x);
        for (int i = n - cnt + 1; i < n; ++i) {
            if (cards[i] % 2 != x % 2) {
                ans = Math.max(ans, replaceSum(cards, cnt, s, cards[i]));
                break;
            }
        }
        return ans;
    }

    private int replaceSum(int[] cards, int cnt, int s, int x) {
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if (cards[i] % 2 != x % 2) {
                return s - x + cards[i];
            }
        }
        return 0;
    }
}
