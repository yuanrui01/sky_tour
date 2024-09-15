package org.hypnos;

import java.util.*;

/**
 * 2848. 与车相交的点
 */
public class NumberOfPoints {

    public int numberOfPoints(List<List<Integer>> nums) {
        List<List<Integer>> merge = merge(nums);
        int ans = 0;
        for (List<Integer> integers : merge) {
            ans += integers.get(1) - integers.get(0);
        }
        return ans + merge.size();
    }

    public List<List<Integer>> merge(List<List<Integer>> nums) {
        if (nums.size() <= 1) {
            return List.of(nums.get(0));
        }
        nums.sort(Comparator.comparingInt(a -> a.get(0)));
        List<List<Integer>> merged = new ArrayList<>();
        List<Integer> currentInterval = nums.get(0);
        merged.add(currentInterval);
        for (List<Integer> interval : nums) {
            Integer currentEnd = currentInterval.get(1);
            Integer nextStart = interval.get(0);
            Integer nextEnd = interval.get(1);
            if (currentEnd >= nextStart) {
                currentInterval.set(1, Math.max(currentEnd, nextEnd));
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged;
    }
}
