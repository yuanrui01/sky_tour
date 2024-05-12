package org.hypnos;

/**
 * @author: yuanrui
 */
public class MaximumEnergy {


	public int maximumEnergy(int[] energy, int k) {
		int ans = Integer.MIN_VALUE;
		int length = energy.length;
		for (int i = length - 1; i >= length - k; i--) {
			int tmp = 0;
			for (int j = i; j >= 0; j-=k) {
				tmp += energy[j];
				ans = Math.max(ans, tmp);
			}
		}
		return ans;
	}

	public static void main(String[] args) {


		MaximumEnergy maximumEnergy = new MaximumEnergy();
		System.out.println(
				maximumEnergy.maximumEnergy(new int[]{-2,-3,-1}, 2)
		);
	}
}
