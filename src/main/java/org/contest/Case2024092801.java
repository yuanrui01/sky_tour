package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024092801 {

	public int minElement(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			int sumOfDigits = 0;
			while (num > 0) {
				sumOfDigits += num % 10;
				num /= 10;
			}
			min = Math.min(min, sumOfDigits);
		}
		return min;
	}




	public int minStartingIndex(String s, String pattern) {
		int lenS = s.length();
		int lenPattern = pattern.length();
		if (lenPattern > lenS) {
			return -1;
		}
		int ans = -1;
		for (int i = 0; i <= lenS - lenPattern; i++) {
			int mismatch = 0;
			for (int j = 0; j < lenPattern; j++) {
				if (s.charAt(i + j) != pattern.charAt(j)) {
					mismatch++;
					if (mismatch > 1) break;
				}
			}
			if (mismatch <= 1) {
				if (ans == -1 || i < ans) {
					ans = i;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {

	}
}
