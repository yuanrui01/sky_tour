package org.hypnos;

import java.util.*;

/**
 * 2192. 有向无环图中一个节点的所有祖先
 */
public class GetAncestors {

	public List<List<Integer>> getAncestors(int n, int[][] edges) {
		List<Integer>[] g = new List[n];
		boolean[] visited = new boolean[n];
		Arrays.setAll(g, i -> new ArrayList<>());
		for (int[] edge : edges) {
			g[edge[1]].add(edge[0]);
		}

		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			Arrays.fill(visited, false);
			dfs(g, visited, i);
			visited[i] = false;
			List<Integer> il = new ArrayList<>();
			for (int j = 0; j < n; ++j) {
				if (visited[j])
					il.add(j);
			}
			ans.add(il);
		}

		return ans;
	}

	private void dfs(List<Integer>[] g, boolean[] visited, int i) {
		visited[i] = true;
		for (Integer j : g[i]) {
			if (!visited[j]) {
				dfs(g, visited, j);
			}
		}
	}

	public static void main(String[] args) {
		int n = 8;
		int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
		GetAncestors getAncestors = new GetAncestors();
		System.out.println(getAncestors.getAncestors(n, edges));
	}
}
