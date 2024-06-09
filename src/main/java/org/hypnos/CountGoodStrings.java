package org.hypnos;

public class CountGoodStrings {

	private static final int LIMIT = 1_000_000_007;

	public int countGoodStrings(int low, int high, int zero, int one) {
		int[] ans = new int[high + 1];
		int total = 0;
		ans[0] = 1;
		for(int i = 1; i <= high; ++i) {
			if (i >= zero)
				ans[i] = ans[i - zero] % LIMIT;
			if (i >= one)
				ans[i] = (ans[i] + ans[i - one]) % LIMIT;
			if (i >= low)
				total = (total + ans[i]) % LIMIT;
		}
		return total;
	}

    public static void main(String[] args) {
        CountGoodStrings countGoodStrings = new CountGoodStrings();
        int low = 50000;
        int high = 99999;
        int zero = 2;
        int one = 3;
        System.out.println(countGoodStrings.countGoodStrings(low, high, zero, one));
    }
}
