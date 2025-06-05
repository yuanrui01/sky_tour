package org.hypnos;

/**
 * 1061. 按字典序排列最小的等效字符串
 */
public class SmallestEquivalentString {

	public String smallestEquivalentString(String s1, String s2, String baseStr) {
		int[] fa = new int[26];
		for (int i = 0; i < 26; i++) {
			fa[i] = i;
		}

		for (int i = 0; i < s1.length(); i++) {
			merge(fa, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
		}

		char[] s = baseStr.toCharArray();
		for (int i = 0; i < s.length; i++) {
			s[i] = (char) (find(fa, s[i] - 'a') + 'a');
		}
		return new String(s);
	}

	private int find(int[] fa, int x) {
		if (fa[x] != x) {
			fa[x] = find(fa, fa[x]);
		}
		return fa[x];
	}

	private void merge(int[] fa, int x, int y) {
		int fx = find(fa, x);
		int fy = find(fa, y);
		// 把大的代表元指向小的代表元
		if (fx < fy) {
			fa[fy] = fx;
		} else {
			fa[fx] = fy;
		}
	}

	public static void main(String[] args) {
		String s1 = "leetcode";
		String s2 = "programs";
		String baseStr = "sourcecode";
		SmallestEquivalentString smallestEquivalentString = new SmallestEquivalentString();
		System.out.println(smallestEquivalentString.smallestEquivalentString(s1,s2,baseStr));
	}
}
