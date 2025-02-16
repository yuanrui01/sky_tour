package org.hypnos;

/**
 * 1299. 将每个元素替换为右侧最大元素
 */
public class ReplaceElements {

	public int[] replaceElements(int[] arr) {
		int n = arr.length;
		int mx = -1;
		for (int j = n-1; j >= 0; j--) {
			int tmp = arr[j];
			arr[j] = mx;
			mx = Math.max(mx, tmp);
		}
		return arr;
	}
}
