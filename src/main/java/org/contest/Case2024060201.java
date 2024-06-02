package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024060201 {



	public int minimumChairs(String s) {
		char[] charArray = s.toCharArray();
		int ans = 0;
		int tAns = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'E')
				tAns++;
			else
				tAns--;
			ans = Math.max(ans, tAns);
		}
		return ans;
	}


	public static void main(String[] args) {
		String s = "ELEELEELLL";

		Case2024060201 case2024060201 = new Case2024060201();
		System.out.println(case2024060201.minimumChairs(s));
	}
}
