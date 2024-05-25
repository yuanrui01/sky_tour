package org.template;

/**
 * 快速幂模板代码
 */
public class FastPower {
	public static long fastPower(long base, long exp, long mod) {
		long result = 1;
		base = base % mod;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = (result * base) % mod;
			}
			exp = exp >> 1;
			base = (base * base) % mod;
		}
		return result;
	}

	public static void main(String[] args) {
		long base = 2;
		long exp = 15;
		long mod = 1000000007;
		fastPower(base, exp, mod);
		System.out.println("====================");
		//System.out.println(fastPower(base, exp, mod)); // Output: 1024
	}
}
