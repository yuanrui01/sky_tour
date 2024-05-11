package org.hypnos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class MaxPointsInsideSquare {


	public static int maxPointsInsideSquare(int[][] points, String s) {
		Map<String, Character> map = new HashMap<>();
		Map<Character, Character> existingMap = new HashMap<>();
		int length = s.length();
		if (length == 1)
			return 1;
		for (int i = 0; i < length; i++) {
			map.put(points[i][0] + "," + points[i][1], s.charAt(i));
		}
		Arrays.sort(points, (point1, point2) -> {
			int distance1 = distanceToOrigin(point1[0], point1[1]);
			int distance2 = distanceToOrigin(point2[0], point2[1]);
			return Integer.compare(distance1, distance2);
		});
		int i = 0;
		while (i < length) {
			Character c = map.get(points[i][0] + "," + points[i][1]);
			Character existingChar = existingMap.get(c);
			if (existingChar == null) {
				// 之前不存在元素，直接放入
				existingMap.put(c, c);
			} else {
				// 如果之前存在元素，还需要检查当前元素与上一个元素是否都在边界上
				long curEleDist = distanceToOrigin(points[i][0], points[i][1]);
				long preEleDist = distanceToOrigin(points[i - 1][0], points[i - 1][1]);
				if (curEleDist == preEleDist) {
					int j = i -1;
					while (j >= 0 && curEleDist == distanceToOrigin(points[j][0], points[j][1])) {
						i--;
						j--;
					}
				}
				break;
			}
			++i;
		}

		return i;
	}

	public static int distanceToOrigin(int x, int y) {
		return Math.max(Math.abs(x), Math.abs(y));
	}

	public static void main(String[] args) {
		int[][] points = {{1,1},{-1,-1},{2,-2}};
		String s = "ccd";

		MaxPointsInsideSquare maxPointsInsideSquare = new MaxPointsInsideSquare();
		System.out.println(maxPointsInsideSquare.maxPointsInsideSquare(points, s));
	}
}
