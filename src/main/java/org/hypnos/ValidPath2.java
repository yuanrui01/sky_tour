package org.hypnos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1971. 寻找图中是否存在路径 - DFS
 */
public class ValidPath2 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, e -> new ArrayList<>());
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(adj, visited, source, destination);
    }

    private boolean dfs(List<Integer>[] adj, boolean[] visited, int source, int destination) {
        if (source == destination)
            return true;
        visited[source] = true;
        for (Integer newSource : adj[source]) {
            if (!visited[newSource] && dfs(adj, visited, newSource, destination))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0;
        int destination = 5;
        ValidPath2 validPath2 = new ValidPath2();
        System.out.println(validPath2.validPath(n, edges, source, destination));
    }
}
