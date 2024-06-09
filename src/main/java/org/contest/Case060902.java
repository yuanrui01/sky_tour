package org.contest;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class Case060902 {
	private static final int LIMIT = 1000000007;

	public int valueAfterKSeconds(int n, int k) {
		int[] ans = new int[n];
		Arrays.fill(ans, 1);
		for (int i = 0; i < k; ++i) {
			for (int j = 1; j < n; ++j) {
				ans[j] = (ans[j] +  ans[j - 1]) % LIMIT;
			}
		}
		return ans[n - 1];
	}


	public static void main(String[] args) {
		Case060902 case060902 = new Case060902();
		System.out.println(case060902.valueAfterKSeconds(5,3));
	}
}
