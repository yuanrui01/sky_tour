package org.hypnos;


import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径 - DFS
 */
public class AllPathsSourceTarget {

    private List<List<Integer>> ans;
    private List<Integer> cur;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ans = new ArrayList<>();
        cur = new ArrayList<>();
        dfs(graph, 0, n - 1);
        return ans;
    }

    private void dfs(int[][] graph, int source, int destination) {
        if (source == destination) {
            cur.add(source);
            ans.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
        } else {
            for (int newSource : graph[source]) {
                cur.add(source);
                dfs(graph, newSource, destination);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graphs = {{1,2},{3},{3},{}};
        AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
        System.out.println(allPathsSourceTarget.allPathsSourceTarget(graphs));
    }
}
