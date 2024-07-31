package org.hypnos;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3111. 覆盖所有点的最少矩形数目
 */
public class MinRectanglesToCoverPoints {

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int ans = 0;
        Arrays.sort(points, Comparator.comparingInt(ps -> ps[0]));
        int index = 0;
        int len = points.length;
        while (index < len) {
            int tW = w;
            while (index < len - 1 && tW >= points[index + 1][0] - points[index][0]) {
                tW -= points[index + 1][0] - points[index][0];
                index++;
            }
            ans++;
            index++;
        }
        return ans;
    }
}
