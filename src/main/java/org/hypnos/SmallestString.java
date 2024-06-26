package org.hypnos;

/**
 * 2734. 执行子串操作后的字典序最小字符串
 */
public class SmallestString {

	public String smallestString(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int i = 0;
		while (i < len && s.charAt(i) == 'a')
			i++;
		if (i == len)
			return s.substring(0, len - 1) + 'z';
		else {
			sb.append(s, 0, i);
			while (i < len && s.charAt(i) != 'a')
				sb.append((char) (s.charAt(i++) - 1));
			sb.append(s, i, len);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SmallestString smallestString = new SmallestString();

		String s = "acbbc";

		System.out.println(smallestString.smallestString(s));
	}
}
