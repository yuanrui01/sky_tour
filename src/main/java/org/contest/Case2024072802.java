package org.contest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yuanrui
 */
public class Case2024072802 {

	public int nonSpecialCount(int l, int r) {
		Set<Integer> s = new HashSet<>();
		int upperLimit = (int) Math.sqrt(r) + 1;
		for (int i = 2; i <= upperLimit; i++) {
			if (isPrime(i)) {
				int sq = i * i;
				if (sq >= l && sq <= r) {
					s.add(sq);
				}
			}
		}
		int all = r - l + 1;
		return all - s.size();
	}

	private static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		if (n <= 3) {
			return true;
		}
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Case2024072802 case2024072802 = new Case2024072802();

		System.out.println(case2024072802.nonSpecialCount(5,7));
	}
}
