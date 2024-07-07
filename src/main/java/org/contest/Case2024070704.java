package org.contest;

import java.util.*;

/**
 * @author: yuanrui
 */
public class Case2024070704 {

	static class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEnd;
		int minCost;

		public TrieNode() {
			children = new HashMap<>();
			isEnd = false;
			minCost = Integer.MAX_VALUE;
		}
	}

	private static void buildTrie(TrieNode root, String[] words, int[] costs) {
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				if (!curr.children.containsKey(c)) {
					curr.children.put(c, new TrieNode());
				}
				curr = curr.children.get(c);
			}
			curr.isEnd = true;
			curr.minCost = Math.min(curr.minCost, costs[i]);
		}
	}

	public static int minimumCost(String target, String[] words, int[] costs) {
		TrieNode root = new TrieNode();
		buildTrie(root, words, costs);

		int n = target.length();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				TrieNode curr = root;
				for (int j = i; j < n; j++) {
					char c = target.charAt(j);
					if (!curr.children.containsKey(c)) {
						break;
					}
					curr = curr.children.get(c);
					if (curr.isEnd) {
						dp[j + 1] = Math.min(dp[j + 1], dp[i] + curr.minCost);
					}
				}
			}
		}

		return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
	}


	public static void main(String[] args) {
		Case2024070704 case2024070704 = new Case2024070704();
		String target = "wvgafw";
		String[] words = {"wvgafw","w"};
		int[] cost = {1,2};

		System.out.println(case2024070704.minimumCost(target,words,cost));
	}
}
