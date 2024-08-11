package org.contest;

import java.util.List;

/**
 * @author: yuanrui
 */
public class Case2024081101 {


	public int finalPositionOfSnake(int n, List<String> commands) {
		int i = 0;
		int j = 0;

		for (String command : commands) {
			switch (command) {
				case "UP":
					i -= 1;
					break;
				case "DOWN":
					i += 1;
					break;
				case "LEFT":
					j -= 1;
					break;
				case "RIGHT":
					j += 1;
					break;
			}
		}
		return i * n + j;
	}

	public static void main(String[] args) {

	}
}
