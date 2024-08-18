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
		char[] charArray = s.toCharArray();
		for (int i = 0; i < n; ++i) {
			if (charArray[i] == 'A') {
				cntA++;
			} else if (charArray[i] == 'L' && !l3 && i < n - 2 && charArray[i + 1] == 'L' && charArray[i + 2] == 'L') {
					l3 = true;
			}
		}
		return cntA < 2 && !l3;
	}
}
