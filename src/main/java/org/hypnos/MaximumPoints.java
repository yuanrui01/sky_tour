package org.hypnos;

import java.util.Arrays;

/**
 * 100182. 与敌人战斗后的最大分数
 */
public class MaximumPoints {

	public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
		Arrays.sort(enemyEnergies);
		long ans = 0;
		int left = 0;
		int right = enemyEnergies.length;
		while (left < right) {
			if (currentEnergy >= enemyEnergies[left]) {
				ans += currentEnergy / enemyEnergies[left];
				currentEnergy = currentEnergy % enemyEnergies[left];
			} else if (ans > 0) {
				currentEnergy +=  enemyEnergies[--right];
			} else {
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] enemyEnergies = {3,2,2};
		int currentEnergy = 2;
		MaximumPoints maximumPoints = new MaximumPoints();
		System.out.println(maximumPoints.maximumPoints(enemyEnergies, currentEnergy));
	}
}
