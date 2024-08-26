package org.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class Case2024082502 {

	public int countPairs(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (equal1(nums[i], nums[j])) {
					ans++;
				}
			}
		}
		return ans;
	}
	private boolean equal1(int a, int b) {
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		if (s1.length() < s2.length()) {
			s1 = String.format("%0" + s2.length() + "d", a);
		} else if (s2.length() < s1.length()) {
			s2 = String.format("%0" + s1.length() + "d", b);
		}
		if (s1.equals(s2)) {
			return true;
		}
		return equal2(s1, s2);
	}

	private boolean equal2(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			for (int j = i + 1; j < s1.length(); j++) {
				char[] arr = s1.toCharArray();
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				if (new String(arr).equals(s2)) {
					return true;
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		Case2024082502 case2024082502 = new Case2024082502();

		int[] nums = {3,12,30,17,21};
		System.out.println(case2024082502.countPairs(nums));
	}
}
