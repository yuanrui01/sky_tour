package org.hypnos;

/**
 * @author: yuanrui
 */
public class LargestGoodInteger {

	public String largestGoodInteger(String num) {
		int min = '0' - 1;
		int ans = min;
		int len = num.length();
		for (int i = 2; i < len; ++i) {
			if (num.charAt(i) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i-2)) {
				ans = Math.max(ans, num.charAt(i));
			}
		}
		if (ans == min) return "";
		ans = ans - '0';
		return ans + "" + ans + ans;
	}

	public static void main(String[] args) {
		String num = "6777133339";
		LargestGoodInteger largestGoodInteger = new LargestGoodInteger();

		System.out.println(largestGoodInteger.largestGoodInteger(num));
	}
}
