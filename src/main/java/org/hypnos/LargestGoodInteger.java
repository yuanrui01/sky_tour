package org.hypnos;

/**
 * 2264. 字符串中最大的 3 位相同数字
 */
public class LargestGoodInteger {

	public String largestGoodInteger(String num) {
		char ans = 0;
		int len = num.length();
		for (int i = 2; i < len; ++i) {
			if (num.charAt(i) >  ans && num.charAt(i) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i-2)) {
				ans = num.charAt(i);
			}
		}
		return ans > 0 ? String.valueOf(ans).repeat(3) : "";
	}

	public static void main(String[] args) {
		String num = "6777133339";
		LargestGoodInteger largestGoodInteger = new LargestGoodInteger();

		System.out.println(largestGoodInteger.largestGoodInteger(num));
	}
}
