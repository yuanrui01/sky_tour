package org.contest;

import java.util.*;

/**
 * @author: yuanrui
 */
public class Case2024100602 {

	public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
		List<Integer>[] g = new List[n];
		Arrays.setAll(g, e -> new ArrayList<>());
		for (int[] invocation : invocations) {
			g[invocation[0]].add(invocation[1]);
		}
		Set<Integer> sus = new HashSet<>();
		dfs(k, g, sus);
		Set<Integer> rem = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!sus.contains(i)) {
				rem.add(i);
			}
		}
		for (int[] invocation : invocations) {
			if (sus.contains(invocation[1]) && rem.contains(invocation[0])) {
				return getAll(n);
			}
		}
		return new ArrayList<>(rem);
	}

	private void dfs(int method, List<Integer>[] g, Set<Integer> sus) {
		if (sus.contains(method)) {
			return;
		}
		sus.add(method);
		for (int next : g[method]) {
			dfs(next, g, sus);
		}
	}

	private List<Integer> getAll(int n) {
		List<Integer> all = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			all.add(i);
		}
		return all;
	}

	public static void main(String[] args) {

	}
}
