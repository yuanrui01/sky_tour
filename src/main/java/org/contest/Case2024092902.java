package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024092902 {

	public int countOfSubstrings(String word, int k) {
		int n = word.length();
		int count = 0;
		int left = 0;
		int vowelCount = 0;
		int consonantCount = 0;
		boolean[] vowels = new boolean[5];
		int lastValidVowelIndex = -1; // 记录上一个满足5个元音条件的位置

		for (int right = 0; right < n; right++) {
			char ch = word.charAt(right);

			if (isVowel(ch)) {
				int index = vowelIndex(ch);
				if (!vowels[index]) {
					vowels[index] = true;
					vowelCount++;
					if (vowelCount == 5) {
						lastValidVowelIndex = right; // 更新上一个有效元音位置
					}
				}
			} else {
				consonantCount++;
			}

			while(vowelCount == 5 && consonantCount > k) {
				char leftChar = word.charAt(left);
				if (isVowel(leftChar)) {
					int index = vowelIndex(leftChar);
					if (left == lastValidVowelIndex) { // 如果移除的是最后一个有效元音，则需要重新查找
						lastValidVowelIndex = findLastValidVowelIndex(vowels, word, left + 1, right);
					}
					vowels[index] = false;
					vowelCount--;
				} else {
					consonantCount--;
				}
				left++;
			}

			if (vowelCount == 5 && consonantCount == k) {
				count += (lastValidVowelIndex - left + 1); //  累加以right结尾的有效子串数量
			}
		}

		return count;
	}

	//  辅助函数：查找上一个有效元音位置
	private int findLastValidVowelIndex(boolean[] vowels, String word, int start, int end) {
		for (int i = end; i >= start; i--) {
			if (isVowel(word.charAt(i)) && vowels[vowelIndex(word.charAt(i))]) {
				return i;
			}
		}
		return -1;
	}

	private boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

	private int vowelIndex(char ch) {
		switch (ch) {
			case 'a': return 0;
			case 'e': return 1;
			case 'i': return 2;
			case 'o': return 3;
			case 'u': return 4;
			default: return -1;
		}
	}


	public static void main(String[] args) {

	}
}
