package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024081802 {

	public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
		int n = energyDrinkA.length;
		long[] dpA = new long[n];
		long[] dpB = new long[n];
		dpA[0] = energyDrinkA[0];
		dpB[0] = energyDrinkB[0];
		for (int i = 1; i < n; i++) {
			dpA[i] = Math.max(dpA[i - 1] + energyDrinkA[i], dpB[i - 1]);
			dpB[i] = Math.max(dpB[i - 1] + energyDrinkB[i], dpA[i - 1]);
		}
		return Math.max(dpA[n - 1], dpB[n - 1]);
	}


	public static void main(String[] args) {
		int[] energyDrinkA = {1,3,1};
		int[] energyDrinkB = {3,1,1};
		Case2024081802 case2024081802 = new Case2024081802();
		System.out.println(case2024081802.maxEnergyBoost(energyDrinkA, energyDrinkB));
	}
}
