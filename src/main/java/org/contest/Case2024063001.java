package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024063001 {

	public int maxHeightOfTriangle(int red, int blue) {
		int ans1 = beginWithBlue(red, blue);
		int ans2 = beginWithRed(red, blue);
		return Math.max(ans1, ans2);
	}

	private int beginWithRed(int red, int blue) {
		int height = 0;
		boolean isRed = true;
		while (true) {
			if (isRed) {
				isRed = false;
				if (red >= height + 1) {
					red -= (height + 1);
					height++;
				} else {
					break;
				}
			} else {
				isRed = true;
				if (blue >= height + 1) {
					blue -= (height + 1);
					height++;
				} else {
					break;
				}
			}
		}
		return height;
	}

	private int beginWithBlue(int red, int blue) {
		int height = 0;
		boolean isBlue = true;
		while (true) {
			if (isBlue) {
				isBlue = false;
				if (blue >= height + 1) {
					blue -= (height + 1);
					height++;
				} else {
					break;
				}
			} else {
				isBlue = true;
				if (red >= height + 1) {
					red -= (height + 1);
					height++;
				} else {
					break;
				}
			}
		}
		return height;
	}


	public static void main(String[] args) {

		Case2024063001 case2024063001 = new Case2024063001();
		System.out.println(case2024063001.maxHeightOfTriangle(10, 1));
	}
}
