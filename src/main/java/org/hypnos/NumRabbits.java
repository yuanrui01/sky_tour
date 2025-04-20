package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 */
public class NumRabbits {

	public int numRabbits(int[] answers) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int answer : answers) {
			map.merge(answer, 1, Integer::sum);
		}
		int ans = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int k = entry.getKey();
			int v = entry.getValue();
			ans +=  (v / (k + 1)) * (k + 1);
			if (v % (k + 1) != 0) {
				ans += k + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] answers = {1,1,2};
		NumRabbits numRabbits = new NumRabbits();

		System.out.println(numRabbits.numRabbits(answers));
	}
}
