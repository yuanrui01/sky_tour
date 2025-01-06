package org.simulation;

import java.util.Arrays;

/**
 * 2241. 设计一个 ATM 机器
 */
public class ATM {

	private final int[] deposit;
	private final int[] values = {20, 50, 100, 200, 500};
	private final int size = 5;

	public ATM() {
		deposit = new int[size];
	}

	public void deposit(int[] banknotesCount) {
		for (int i = 0; i < size; ++i) {
			deposit[i] += banknotesCount[i];
		}
	}

	public int[] withdraw(int amount) {
		int[] result = new int[size];
		for (int i = 4; i >= 0; --i) {
			if (deposit[i] > 0 && amount >= values[i]) {
				int t = amount / values[i];
				t = Math.min(t, deposit[i]);
				result[i] = t;
				deposit[i] -= t;
				amount -= values[i] * result[i];
			}
		}
		if (amount != 0) {
			for (int i = 0; i < size; ++i) {
				deposit[i] += result[i];
			}
			return new int[]{-1};
		}
		return result;
	}

	public static void main(String[] args) {
		ATM atm = new ATM();
//		atm.deposit(new int[]{0,0,1,2,1});
//		System.out.println(Arrays.toString(atm.withdraw(600)));
//		atm.deposit(new int[]{0,1,0,1,1});
//		System.out.println(Arrays.toString(atm.withdraw(600)));
//		System.out.println(Arrays.toString(atm.withdraw(550)));



		atm.deposit(new int[]{0,10,0,3,0});
		System.out.println(Arrays.toString(atm.withdraw(500)));
	}
}
