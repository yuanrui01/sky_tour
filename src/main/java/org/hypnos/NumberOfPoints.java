package org.hypnos;

import java.util.*;

/**
 * 2848. 与车相交的点
 */
public class NumberOfPoints {

    public int numberOfPoints(List<List<Integer>> nums) {
        if (nums.size() <= 1) {
            return nums.get(0).get(1) - nums.get(0).get(0) + 1;
        }
        int ans = 0;
        nums.sort(Comparator.comparingInt(a -> a.get(0)));
        List<Integer> currentInterval = nums.get(0);
        for (List<Integer> interval : nums) {
            Integer currentEnd = currentInterval.get(1);
            Integer nextStart = interval.get(0);
            Integer nextEnd = interval.get(1);
            if (currentEnd >= nextStart) {
                currentInterval.set(1, Math.max(currentEnd, nextEnd));
            } else {
                ans += currentEnd - currentInterval.get(0) + 1;
                currentInterval = interval;
            }
        }
        ans += currentInterval.get(1) - currentInterval.get(0) + 1;
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> trueL = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(8);
        trueL.add(list1);
        trueL.add(list2);
        NumberOfPoints numberOfPoints = new NumberOfPoints();
        System.out.println(numberOfPoints.numberOfPoints(trueL));
    }
}
