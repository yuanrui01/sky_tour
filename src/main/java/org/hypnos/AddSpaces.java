package org.hypnos;

/**
 * 2109. 向字符串添加空格
 */
public class AddSpaces {

	public String addSpaces(String s, int[] spaces) {
		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int n = arr.length;
		int m = spaces.length;
		int j = 0;
		for (int i = 0; i < n; ++i) {
			if (j < m && i == spaces[j]) {
				sb.append(" ");
				j++;
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
