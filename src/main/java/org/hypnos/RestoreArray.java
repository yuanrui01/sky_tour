package org.hypnos;


import java.util.*;

/**
 * 1743. 从相邻元素对还原数组
 */
public class RestoreArray {

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int[] ans = new int[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : adjacentPairs) {
            map.computeIfAbsent(p[0], e -> new ArrayList<>()).add(p[1]);
            map.computeIfAbsent(p[1], e -> new ArrayList<>()).add(p[0]);
        }
        int start = -1;
        for (Integer i : map.keySet()) {
            if (map.get(i).size() == 1) {
                start = i;
                break;
            }
        }
        ans[0] = start;
        for (int i = 0; i < n; ++i) {
            List<Integer> adj = map.get(ans[i]);
            map.remove(ans[i]);
            for (Integer is : adj) {
                if (map.containsKey(is)) {
                    ans[i+1] = is;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RestoreArray restoreArray = new RestoreArray();
        int[][] nums = {{2,1},{3,4},{3,2}};
        System.out.println(Arrays.toString(restoreArray.restoreArray(nums)));
    }
}
