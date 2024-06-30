package org.ds;

/**
 * 1524. 和为奇数的子数组数目
 */
public class NumOfOddSubarrays {

	private static final int MOD = 1_000_000_007;
	public int numOfSubarrays(int[] arr) {
		int odd = 0;
		int even = 1;
		int sum = 0;
		int ans = 0;

		for (int j : arr) {
			sum += j;
			ans = (ans + (sum % 2 == 0 ? odd : even)) % MOD;
			if (sum % 2 == 0)
				even++;
			else
				odd++;
		}
		return ans;
	}

	public static void main(String[] args) {

		NumOfOddSubarrays numOfOddSubarrays = new NumOfOddSubarrays();
		int[] arr = {0, 1, 1, 1, 0};

		System.out.println(numOfOddSubarrays.numOfSubarrays(arr));
	}
}
