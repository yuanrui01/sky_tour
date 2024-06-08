package org.contest;

/**
 * @author: yuanrui
 */
public class Case060801 {


	public String clearDigits(String s) {
		char[] charArray = s.toCharArray();
		int n = charArray.length;
		boolean[] sMode = new boolean[n];

		for (int i = 0; i < n; ++i) {
			char c = charArray[i];
			if (c <= '9' && c >= '0') {
				sMode[i] = true;
				for (int j = i - 1; j >= 0; j--) {
					char cj = charArray[j];
					if (cj >= 'a' && cj <= 'z' && !sMode[j]) {
						sMode[j] = true;
						break;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			if (!sMode[i])
				sb.append(charArray[i]);
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		String s = "acb34";
		Case060801 case060801 = new Case060801();
		System.out.println(case060801.clearDigits(s));

	}
}
