package org.hypnos;


import java.util.*;

/**
 * 2080. 区间内查询数字的频率
 */
public class RangeFreqQuery {

    private Map<Integer, List<Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length;  ++i) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = map.getOrDefault(value, Collections.emptyList());
        return binarySearch(list, right + 1) - binarySearch(list, left);
    }


    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
