package org.hypnos;


/**
 * 1423. 可获得的最大点数
 */
public class MaxScore2 {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }

        int tSum = 0;
        int window = cardPoints.length - k;
        for (int i = 0; i < window; ++i) {
            tSum += cardPoints[i];
        }
        int minSum = tSum;
        for (int i = window; i < cardPoints.length; ++i) {
            tSum += cardPoints[i];
            tSum -= cardPoints[i - window];
            minSum = Math.min(minSum, tSum);
        }

        return sum - minSum;
    }
}
