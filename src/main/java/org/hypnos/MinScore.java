package org.hypnos;

import java.util.*;


/**
 * 2492. 两个城市间路径的最小分数
 */
public class MinScore {

    private int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new List[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        boolean[] visited = new boolean[n+1];
        for (int[] road : roads) {
            g[road[0]].add(new int[]{road[1], road[2]});
            g[road[1]].add(new int[]{road[0], road[2]});
        }
        dfs(g, visited, 1);
        return ans;
    }

    private void dfs(List<int[]>[] g, boolean[] visited, int source) {
        visited[source] = true;
        for (int[] newSource : g[source]) {
            ans = Math.min(ans, newSource[1]);
            if (!visited[newSource[0]])
                dfs(g, visited, newSource[0]);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] roads = {{4,5,7468},{6,2,7173},{6,3,8365},{2,3,7674},{5,6,7852},{1,2,8547},{2,4,1885},{2,5,5192},{1,3,4065},{1,4,7357}};
        MinScore minScore = new MinScore();
        System.out.println(minScore.minScore(n, roads));
    }
}
