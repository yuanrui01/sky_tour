package org.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: yuanrui
 */
public class Case2024081102 {

	public int countGoodNodes(int[][] edges) {
		int n = edges.length + 1;
		List<List<Integer>> g = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			g.add(new ArrayList<>());
		}
		for (int[] e : edges) {
			g.get(e[0]).add(e[1]);
			g.get(e[1]).add(e[0]);
		}
		int[] count = {0};
		dfs(0, -1, g, count);
		return count[0];
	}

	private int dfs(int node, int parent, List<List<Integer>> g, int[] count) {
		int subtreeSize = 1;  // 当前节点的子树大小
		List<Integer> childSizes = new ArrayList<>();
		boolean isLeaf = true;
		for (int neighbor : g.get(node)) {
			if (neighbor == parent) {
				continue;
			}
			isLeaf = false;
			int childSubtreeSize = dfs(neighbor, node, g, count);
			childSizes.add(childSubtreeSize);
			subtreeSize += childSubtreeSize;
		}
		if (isLeaf || (!childSizes.isEmpty() && new HashSet<>(childSizes).size() == 1)) {
			count[0]++;
		}
		return subtreeSize;
	}

	public static void main(String[] args) {
		int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
		Case2024081102 case2024081102 = new Case2024081102();
		System.out.println(case2024081102.countGoodNodes(edges));
	}
}
