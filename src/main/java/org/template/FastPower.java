package org.template;

/**
 * 快速幂模板代码
 */
public class FastPower {
	// Function to calculate (base^exp) % mod
	public static long fastPower(long base, long exp, long mod) {
		long result = 1;
		base = base % mod;
		while (exp > 0) {
			// If exp is odd, multiply base with result
			if ((exp & 1) == 1) {
				result = (result * base) % mod;
			}
			// exp must be even now
			exp = exp >> 1; // exp = exp / 2
			base = (base * base) % mod; // Change base to base^2
		}
		return result;
	}

	public static void main(String[] args) {
		long base = 2;
		long exp = 10;
		long mod = 1000000007;
		System.out.println(fastPower(base, exp, mod)); // Output: 1024
	}
}
