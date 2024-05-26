package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024052602 {

	public String compressedString(String word) {
		StringBuilder sb = new StringBuilder();
		char[] charArray = word.toCharArray();
		int length = charArray.length;
		for (int k = 1, index = 0; index < length; index++, k = 1) {
			char curC = charArray[index];
			if (index < length - 1) {
				while (index < length - 1 && charArray[index + 1] == curC && k < 9) {
					k++;
					index++;
				}
			}
			sb.append(k);
			sb.append(curC);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String words = "abcde";
		String s = new Case2024052602().compressedString(words);
		System.out.println(s);
	}
}
