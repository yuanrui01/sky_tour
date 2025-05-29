package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3372. 连接两棵树后最大目标节点数目 I
 */
public class MaxTargetNodes {

	public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
		int max2 = 0;
		if (k > 0) {
			List<Integer>[] g = buildTree(edges2);
			for (int i = 0; i < edges2.length + 1; i++) {
				max2 = Math.max(max2, dfs(i, -1, 0, g, k - 1)); // 注意这里传的是 k-1
			}
		}

		List<Integer>[] g = buildTree(edges1);
		int[] ans = new int[edges1.length + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = dfs(i, -1, 0, g, k) + max2;
		}
		return ans;
	}

	private List<Integer>[] buildTree(int[][] edges) {
		List<Integer>[] g = new ArrayList[edges.length + 1];
		Arrays.setAll(g, i -> new ArrayList<>());
		for (int[] e : edges) {
			int x = e[0];
			int y = e[1];
			g[x].add(y);
			g[y].add(x);
		}
		return g;
	}

	private int dfs(int x, int fa, int d, List<Integer>[] g, int k) {
		if (d > k) {
			return 0;
		}
		int cnt = 1;
		for (int y : g[x]) {
			if (y != fa) {
				cnt += dfs(y, x, d + 1, g, k);
			}
		}
		return cnt;
	}
}
