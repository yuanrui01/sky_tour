package org.hypnos;

/**
 * 3019. 按键变更的次数
 */
public class CountKeyChanges {

	public int countKeyChanges(String s) {
		int length = s.length();
		int cnt = 0;
		for (int i = 1; i < length; ++i) {
			int abs = Math.abs(s.charAt(i) - s.charAt(i - 1));
			if (abs != 0 && abs != 32) {
				cnt++;
			}
		}
		return cnt;
	}


	public static void main(String[] args) {
		CountKeyChanges countKeyChanges = new CountKeyChanges();

		System.out.println(countKeyChanges.countKeyChanges("aAbBcC"));
	}
}
