package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024070601 {

	public int numberOfAlternatingGroups(int[] colors) {
		int n = colors.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			boolean isValid = true;
			for (int j = 1; j < 3; j++) {
				if (colors[(i + j) % n] == colors[(i + j - 1) % n]) {
					isValid = false;
					break;
				}
			}
			if (isValid)
				ans += 1;
		}
		return ans;
	}


	public static void main(String[] args) {
		Case2024070601 case2024070601 = new Case2024070601();
		int[] colors = {0,1,0,0,1};

		System.out.println(case2024070601.numberOfAlternatingGroups(colors));

	}
}
