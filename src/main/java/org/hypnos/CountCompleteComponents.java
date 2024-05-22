package org.hypnos;

import java.util.*;


/**
 * 2685. 统计完全连通分量的数量 - 并查集做法
 */
public class CountCompleteComponents {

    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Set<String> tech = new HashSet<>();
        for (int[] edge : edges) {
            union(parent, depth, edge[0], edge[1]);
            tech.add(edge[0] + "-" +edge[1]);
            tech.add(edge[1] + "-" +edge[0]);
        }

        Map<Integer, List<Integer>> gMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            List<Integer> list = gMap.get(root);
            if (list == null) {
                List<Integer> v = new ArrayList<>();
                v.add(i);
                gMap.put(root, v);
            } else {
                list.add(i);
            }
        }

        int ans = 0;
        for (List<Integer> v : gMap.values()) {
            int vSize = v.size();
            int cnt = 0;
            for (int i = 0; i < vSize; ++i) {
                for (int j = i + 1; j < vSize; ++j) {
                    if (tech.contains(v.get(i) + "-" + v.get(j))) {
                        cnt++;
                    }
                }
            }
            if (cnt == (vSize * (vSize - 1) / 2))
                ans++;
        }
        return ans;
    }

    private void union(int[] parent, int[] depth, int i, int j) {
        int iRoot = find(parent, i);
        int jRoot = find(parent, j);
        if (iRoot != jRoot) {
            if (depth[iRoot] < depth[jRoot]) {
                parent[iRoot] = jRoot;
            } else {
                parent[jRoot] = iRoot;
                if (depth[iRoot] == depth[jRoot])
                    depth[iRoot]++;
            }
        }
    }

    private int find(int[] parent, int i) {
        return parent[i] == i ? i : (parent[i] = find(parent, parent[i]));
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {{1,0}};

        CountCompleteComponents countCompleteComponents = new CountCompleteComponents();
        System.out.println(countCompleteComponents.countCompleteComponents(n, edges));
    }
}
