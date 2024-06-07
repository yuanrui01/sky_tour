package org.hypnos;

import java.util.*;


/**
 * 面试题 17.18. 最短超串
 */
public class ShortestSeq {

    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> mode = new HashSet<>();
        for (int i : small) {
            mode.add(i);
        }
        Map<Integer, Integer> curCount = new HashMap<>();
        int left = 0, right = 0;
        int n = big.length;
        int[] ans = new int[]{};
        int min = Integer.MAX_VALUE;
        while (right < n) {
            if (mode.contains(big[right]))
                curCount.merge(big[right], 1, Integer::sum);
            while (left < right && check(curCount, big[left], mode)) {
                if (mode.contains(big[left]))
                    curCount.merge(big[left], -1, Integer::sum);
                left++;
            }
            if (match(curCount, mode)) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    ans = new int[]{left, right};
                }
            }
            right++;
        }
        return ans;
    }

    private boolean match(Map<Integer, Integer> curCount, Set<Integer> mode) {
        for (Integer i : mode) {
            if (curCount.get(i) == null)
                return false;
        }
        return true;
    }

    private boolean check(Map<Integer, Integer> curCount, int ele, Set<Integer> mode) {
        return !mode.contains(ele) || curCount.getOrDefault(ele, 0) > 1;
    }

    public static void main(String[] args) {
        int[] big = {1,2,3};
        int[] small = {4};

        ShortestSeq shortestSeq = new ShortestSeq();
        int[] res = shortestSeq.shortestSeq(big, small);
        System.out.println(Arrays.toString(res));
    }
}
