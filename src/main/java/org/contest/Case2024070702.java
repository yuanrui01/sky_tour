package org.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanrui
 */
public class Case2024070702 {

	public List<String> validStrings(int n) {
		List<String> ans = new ArrayList<>();
		dfs(n, "", ans);
		return ans;
	}

	private void dfs(int n, String current, List<String> ans) {
		if (current.length() == n) {
			ans.add(current);
			return;
		}
		dfs(n, current + "1", ans);

		if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
			dfs(n, current + "0", ans);
		}
	}


	public static void main(String[] args) {
		Case2024070702 case2024070702 = new Case2024070702();

		System.out.println(case2024070702.validStrings(1));

	}
}
