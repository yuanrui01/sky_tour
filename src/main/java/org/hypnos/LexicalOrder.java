package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 */
public class LexicalOrder {

	public List<Integer> lexicalOrder(int n) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i < 10; ++i) {
			dfs(i, n, ans);
		}
		return ans;
	}

	private void dfs(int n, int mx, List<Integer> ans) {
		if (n > mx) {
			return;
		}
		ans.add(n);
		if (n == mx) {
			return;
		}
		int nn = n * 10;
		for (int i = 0; i < 10; ++i) {
			dfs(nn + i, mx, ans);
		}
	}

	public static void main(String[] args) {
		LexicalOrder lexicalOrder = new LexicalOrder();
		System.out.println(lexicalOrder.lexicalOrder(13));
	}
}
