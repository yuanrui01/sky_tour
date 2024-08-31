package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024083102 {

	public String stringHash(String s, int k) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i += k) {
			String sub = s.substring(i, i + k);
			int hash = 0;
			for (char c : sub.toCharArray()) {
				hash += c - 'a';
			}
			char c = (char) ('a' + (hash % 26));
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {

	}
}
