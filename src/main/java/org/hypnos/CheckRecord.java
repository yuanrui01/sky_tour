package org.hypnos;

/**
 * 551. 学生出勤记录 I
 * @author: yuanrui
 */
public class CheckRecord {

	public boolean checkRecord(String s) {
		int cntA = 0;
		boolean l3 = false;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == 'A')
				cntA++;
			else if (s.charAt(i) == 'L' && !l3) {
				if (i < n - 2 && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
					l3 = true;
				}
			}
		}
		return cntA < 2 && !l3;
	}
}
