package org.hypnos;

/**
 * 3270. 求出数字答案
 */
public class GenerateKey {


	// 9876
	public int generateKey(int num1, int num2, int num3) {
		int key = 0;
		int factor = 1;
		for (int i = 0; i < 4; ++i) {
			int i1 = num1 % 10;
			int i2 = num2 % 10;
			int i3 = num3 % 10;
			key += factor * Math.min(i1, Math.min(i2, i3));
			factor *= 10;
			num1 /= 10;
			num2 /= 10;
			num3 /= 10;
		}
		return key;
	}
}
