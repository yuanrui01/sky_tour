package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 */
public class NumRabbits {

	public int numRabbits(int[] answers) {
		int[] count = new int[1001];
		for (int answer : answers) {
			count[answer]++;
		}
		int ans = 0;
		for (int k = 0; k < 1001; ++k) {
			if (count[k] > 0) {
				int v = count[k];
				ans +=  (v / (k + 1)) * (k + 1);
				if (v % (k + 1) != 0) {
					ans += k + 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] answers = {1,0,1,0,0};
		NumRabbits numRabbits = new NumRabbits();

		System.out.println(numRabbits.numRabbits(answers));
	}
}
