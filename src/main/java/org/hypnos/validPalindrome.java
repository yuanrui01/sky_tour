package org.hypnos;

/**
 * 680. Valid Palindrome II
 */
public class ValidPalindrome {


	// aebcdeedcba
	public boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return valid(s, left + 1, right) || valid(s, left, right-1);
			}
			left++;
			right--;
		}
		return true;
	}

	private boolean valid(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}
