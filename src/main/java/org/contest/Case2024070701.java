package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024070701 {

	public String getEncryptedString(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		k =  k % n;
		for (int i = 0; i < n; ++i) {
			sb.append(s.charAt((i + k) % n));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Case2024070701 case2024070701 = new Case2024070701();

		String s = "aaa";
		int k  =1;
		System.out.println(case2024070701.getEncryptedString(s, k));
	}
}
