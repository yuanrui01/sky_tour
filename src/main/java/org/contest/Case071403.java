package org.contest;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class Case071403 {

	public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
		Arrays.sort(horizontalCut);
		Arrays.sort(verticalCut);
		int hi = horizontalCut.length - 1;
		int vi = verticalCut.length - 1;
		int horizontalPieces = 1;
		int verticalPieces = 1;
		long result = 0;
		while (hi >= 0  && vi >= 0) {
			if (horizontalCut[hi] >= verticalCut[vi]) {
				result += (long)horizontalCut[hi] * verticalPieces;
				horizontalPieces++;
				hi--;
			} else {
				result += (long)verticalCut[vi] * horizontalPieces;
				verticalPieces++;
				vi--;
			}
		}
		while (hi >= 0) {
			result += (long)horizontalCut[hi] * verticalPieces;
			hi--;
		}
		while (vi >= 0) {
			result += (long)verticalCut[vi] * horizontalPieces;
			vi--;
		}
		return result;
	}


	public static void main(String[] args) {
		Case071403 case071403 = new Case071403();
		int m = 3;
		int n = 2;
		int[] horizontalCut = {1, 3};
		int[] verticalCut = {5};
		System.out.println(case071403.minimumCost(m, n, horizontalCut, verticalCut));
	}
}
