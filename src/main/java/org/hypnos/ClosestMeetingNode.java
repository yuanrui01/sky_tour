package org.hypnos;


import java.util.*;

/**
 * 2359. 找到离给定两个节点最近的节点
 */
public class ClosestMeetingNode {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] ans = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int n = edges.length;
        boolean[] vis = new boolean[n];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            if (edges[i] != -1) {
                g[i].add(edges[i]);
            }
        }
        Map<Integer, Integer> dis1 = new HashMap<>();
        dfs(node1, 0, dis1, g, vis);

        Map<Integer, Integer> dis2 = new HashMap<>();
        Arrays.fill(vis, false);
        dfs(node2, 0, dis2, g, vis);

        for (Map.Entry<Integer, Integer> entry1 : dis1.entrySet()) {
            int k1 = entry1.getKey();
            Integer v2 = dis2.getOrDefault(k1, Integer.MAX_VALUE);

            int t = Math.max(entry1.getValue(), v2);
            if (ans[0] > t) {
                ans[0] = t;
                ans[1] = k1;
            } else if (ans[0] == t && ans[1] != Integer.MAX_VALUE && k1 < ans[1]) {
                ans[1] = k1;
            }
        }
        return ans[1] == Integer.MAX_VALUE ? -1 : ans[1];
    }
    
    private void dfs(int node, int d, Map<Integer, Integer> dis, List<Integer>[] g, boolean[] vis) {
        vis[node] = true;
        dis.put(node, d);
        for (Integer next : g[node]) {
            if (!vis[next]) {
                dfs(next, d + 1, dis, g, vis);
            }
        }
    }

    public static void main(String[] args) {
        int[] edges = {5,4,5,4,3,6,-1};
        int node1 = 0;
        int node2 = 1;
        ClosestMeetingNode closestMeetingNode = new ClosestMeetingNode();
        System.out.println(closestMeetingNode.closestMeetingNode(edges, node1, node2));
    }
}
