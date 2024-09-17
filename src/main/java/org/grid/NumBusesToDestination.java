package org.grid;

import java.util.*;

/**
 * 815. 公交路线
 */
public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)  return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int pos : routes[i]) {
                if (map.get(pos) != null) {
                    map.get(pos).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(pos, set);
                }
            }
        }
        Set<Integer> targetStations = map.get(target);
        Set<Integer> sourceStations = map.get(source);
        if (targetStations == null || sourceStations == null) return -1;
        List<Set<Integer>> g = new ArrayList<>();
        for (int[] route : routes) {
            Set<Integer> list = new HashSet<>();
            for (int pos : route) {
                list.addAll(map.get(pos));
            }
            g.add(list);
        }
        int ans = Integer.MAX_VALUE;
        int[] vis = new int[routes.length];
        Arrays.fill(vis, Integer.MAX_VALUE);
        for (Integer sourceStation : sourceStations) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sourceStation, 1});
            vis[sourceStation] = 1;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int station = poll[0];
                int count = poll[1];
                if (targetStations.contains(station)) {
                    ans = Math.min(ans, count);
                }
                for (Integer nextStation : g.get(station)) {
                    if (count + 1 < vis[nextStation]) {
                        vis[nextStation] = count + 1;
                        queue.add(new int[]{nextStation, count + 1});
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        int source = 8;
        int target = 6;
        NumBusesToDestination numBusesToDestination = new NumBusesToDestination();

        System.out.println(numBusesToDestination.numBusesToDestination(routes, source, target));
    }
}
