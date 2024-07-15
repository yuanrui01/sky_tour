package org.contest;

/**
 * @author: yuanrui
 */
public class Case071401 {

	public String getSmallestString(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < s.length() - 1) {
			if (s.charAt(i) > s.charAt(i + 1) && check(s.charAt(i) - '0', s.charAt(i + 1) - '0')) {
				sb.append(s.charAt(i + 1));
				sb.append(s.charAt(i));
				sb.append(s.substring(i + 2));
				return sb.toString();
			}
			sb.append(s.charAt(i++));
		}
		sb.append(s.charAt(i));
		return sb.toString();
	}

	private boolean check(int a, int b) {
		return a % 2 == b % 2;
	}

	public static void main(String[] args) {
		Case071401 case071401 = new Case071401();
		System.out.println(case071401.getSmallestString("10"));

	}
}
