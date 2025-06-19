package org.hypnos;

/**
 * KahanSummation
 */
public class KahanSummation {

	public static void main(String[] args) {
		float sum = 0.0f;
		float c = 0.0f;
		int cntC = 0;
		int cntY = 0;
		float sumY = 0.0f;
		for (int i = 0; i < 20000000; i++) {
			float x = 1.0f;
			float y = x - c;
			float t = sum + y;
			c = (t - sum) - y;
			if (c != 0) {
				cntC++;
			}
			if (y > 1) {
				cntY++;
				sumY += y;
			}
			sum = t;
		}
		float sum2 = 0.0f;
		float inc = 1.0f;
		for (int i = 0; i < 20000000; i++) {
			sum2 += inc;
		}
		System.out.println("cntC is " + cntC);
		System.out.println("cntY is " + cntY);
		System.out.println("sum is " + sum);
		System.out.println("sum2 is " + sum2);
		System.out.println("sumY is " + sumY);
	}
}
