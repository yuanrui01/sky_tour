package org.hypnos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 1610. 可见点的最大数目
 */
public class VisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int removeF = 0;
        int x0 = location.get(0);
        int y0 = location.get(1);
        List<Double> polarDegrees = new ArrayList<>();
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (x == x0 && y == y0) {
                removeF++;
                continue;
            }
            polarDegrees.add(Math.atan2(y - y0, x - x0));
        }
        Collections.sort(polarDegrees);
        int m = polarDegrees.size();
        for (int i = 0; i < m; i++)
            polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);

        int count = 0;
        int right = 0;
        double toDegree = angle * Math.PI / 180;
        for (int i = 0; i < m; ++i) {
            Double curr = polarDegrees.get(i) + toDegree;
            while (right < polarDegrees.size() && polarDegrees.get(right) <= curr) {
                right++;
            }
            count = Math.max(count, right - i);
        }
        return count + removeF;
    }

    public static void main(String[] args) {
        System.out.println(Math.atan2(1,1));
    }
}
