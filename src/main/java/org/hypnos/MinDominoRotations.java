package org.hypnos;

/**
 * 1007. 行相等的最少多米诺旋转
 */
public class MinDominoRotations {

	public int minDominoRotations(int[] tops, int[] bottoms) {
		int ans = Math.min(minRot(tops, bottoms, tops[0]), minRot(tops, bottoms, bottoms[0]));
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	private int minRot(int[] tops, int[] bottoms, int target) {
		int toTop = 0;
		int toBottom = 0;
		for (int i = 0; i < tops.length; i++) {
			int x = tops[i];
			int y = bottoms[i];
			if (x != target && y != target) {
				return Integer.MAX_VALUE;
			}
			if (x != target) {
				toTop++; // 把 y 旋转到上半
			} else if (y != target) {
				toBottom++; // 把 x 旋转到下半
			}
		}
		return Math.min(toTop, toBottom);
	}
}
