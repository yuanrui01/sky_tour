package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 802. 找到最终的安全状态
 */
public class EventualSafeNodes {

	public List<Integer> eventualSafeNodes(int[][] graph) {
		int n = graph.length;
		boolean[] vis = new boolean[n];
		int[] cache = new int[n];
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; ++i)
			if (isSafe(graph, vis, cache, i))
				ans.add(i);
		return ans;
	}

	/**
	 * 判断是否为安全节点，安全节点无环
	 */
	private boolean isSafe(int[][] g, boolean[] vis, int[] cache,  int i) {
		if (cache[i] != 0)
			return cache[i] == 1;
		vis[i] = true;
		for (int v : g[i])
			if (vis[v] || !isSafe(g, vis, cache, v)) {
				cache[i] = 2;
				return false;
			}
		vis[i] = false;
		cache[i] = 1;
		return true;
	}

	public static void main(String[] args) {
		int[][] graph = {{},{0,2,3,4},{3},{4},{}};
		EventualSafeNodes eventualSafeNodes = new EventualSafeNodes();
		System.out.println(eventualSafeNodes.eventualSafeNodes(graph));
	}
}
