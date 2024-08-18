package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024081801 {

	public int countKConstraintSubstrings(String s, int k) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int zeroCount = 0;
			int oneCount = 0;
			for (int j = i; j < n; j++) {
				if (s.charAt(j) == '0') {
					zeroCount++;
				} else {
					oneCount++;
				}
				if (zeroCount <= k || oneCount <= k) {
					ans++;
				} else {
					break;
				}
			}
		}

		return ans;
	}


	public static void main(String[] args) {
		Case2024081801 case2024081801 = new Case2024081801();
		String s = "10101";
		int k = 1;
		System.out.println(case2024081801.countKConstraintSubstrings(s, k));
	}
}
