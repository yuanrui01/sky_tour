package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024092901 {

	public char kthCharacter(int k) {
		StringBuilder word = new StringBuilder("a");
		while (word.length() < k) {
			int len = word.length();
			StringBuilder newSegment = new StringBuilder();
			for (int i = 0; i < len; i++) {
				char nextChar = nextCharacter(word.charAt(i));
				newSegment.append(nextChar);
			}
			word.append(newSegment);
		}

		return word.charAt(k - 1);
	}

	private char nextCharacter(char c) {
		if (c == 'z') {
			return 'a';
		} else {
			return (char) (c + 1);
		}
	}

	public static void main(String[] args) {

	}
}
