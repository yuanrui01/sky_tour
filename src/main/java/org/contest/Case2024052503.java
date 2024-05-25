package org.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class Case2024052503 {


	public int[] queryResults(int limit, int[][] queries) {
		Map<Integer, Integer> ballMap = new HashMap<>();
		Map<Integer, Integer> colorMap = new HashMap<>();

		int[] ans = new int[queries.length];
		int colorCount = 0;
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0];
			int y = queries[i][1];
			Integer ballColor = ballMap.get(x);
			Integer yColor = colorMap.get(y);
			if (ballColor == null) {
				if (yColor == null) {
					colorMap.put(y, 1);
					colorCount++;
				} else {
					if (yColor == 0)
						colorCount++;
					colorMap.merge(y, 1, Integer::sum);
				}
			} else {
				if (ballColor != y) {
					if (colorMap.get(y) == null) {
						colorMap.put(y, 1);
						colorCount++;
					} else {
						colorMap.merge(y, 1, Integer::sum);
						if (colorMap.get(y) == 1)
							colorCount++;
					}
					colorMap.put(ballColor, colorMap.get(ballColor) - 1);
					if (colorMap.get(ballColor) == 0)
						colorCount--;
				}
			}
			ballMap.put(x, y);
			ans[i] = colorCount;
		}
		return ans;
	}


	//[1,1,1,1,2]
	public static void main(String[] args) {
		int limit = 1;
		int[][] queries = {{0,1},{0,4},{0,4},{0,1},{1,2}};

		int[] ints = new Case2024052503().queryResults(limit, queries);
		System.out.println(Arrays.toString(ints));
	}

}
