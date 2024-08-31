package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024083101 {

	public int generateKey(int num1, int num2, int num3) {
		String str1 = String.format("%04d", num1);
		String str2 = String.format("%04d", num2);
		String str3 = String.format("%04d", num3);
		StringBuilder key = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			char minDigit = (char) Math.min(str1.charAt(i), Math.min(str2.charAt(i), str3.charAt(i)));
			key.append(minDigit);
		}
		return Integer.parseInt(key.toString());
	}

	public static void main(String[] args) {
		int num1 = 1, num2 = 10, num3 = 1000;
		Case2024083101 case2024083101 = new Case2024083101();
		System.out.println(case2024083101.generateKey(num1,num2,num3));
	}
}
