package org.slide;

/**
 * 1151. 最少交换次数来组合所有的 1
 * @author: yuanrui
 */
public class minSwaps0 {

	public int minSwaps(int[] data) {
		int k = 0;
		for (int datum : data) {
			k += datum;
		}
		int max = 0;
		int ones = 0;
		for (int i = 0; i < k; ++i) {
			ones += data[i];
		}
		max = Math.max(max, ones);
		for (int i = k; i < data.length; ++i) {
			ones -= data[i - k];
			ones += data[i];
			max = Math.max(max, ones);
		}
		return k - max;
	}
}
