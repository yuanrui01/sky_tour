package org.hypnos;

/**
 * 997. 找到小镇的法官
 */
public class FindJudge {


	public int findJudge(int n, int[][] trust) {
		int[] t1 = new int[n + 1];
		int[] t2 = new int[n + 1];
		for (int[] tr : trust) {
			t1[tr[0]]++;
			t2[tr[1]]++;
		}
		int result = -1;
		int count = 0;
		for (int i = 1; i <= n; ++i) {
			if (t2[i] == n - 1 && t1[i] == 0) {
				count++;
				result = i;
			}
			if (count > 2)
				return -1;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] trust = {{1,3},{2,3}};
		FindJudge findJudge = new FindJudge();
		System.out.println(findJudge.findJudge(n, trust));
	}
}
