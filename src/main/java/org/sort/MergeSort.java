package org.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

	public void sort(int[] nums) {
		int n = nums.length;
		int[] support = new int[n];
		mergeSort(nums, support, 0, n - 1);
	}

	public void mergeSort(int[] nums, int[] aux, int l, int r) {
		if (l >= r) return;
		int m = l + (r-l) / 2;
		mergeSort(nums, aux, l, m);
		mergeSort(nums, aux, m + 1, r);
		System.arraycopy(nums, l, aux, l, r - l + 1);
		int i = l, j = m + 1;
		for (int k = l; k <= r; k++) {
			if (i > m) nums[k] = aux[j++];
			else if (j > r) nums[k] = aux[i++];
			else if (aux[j] > aux[i]) nums[k] = aux[j++];
			else nums[k] = aux[i++];
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] nums = {5,1,4,3};
		System.out.println("before sort: " + Arrays.toString(nums));
		mergeSort.sort(nums);
		System.out.println("after sort: " + Arrays.toString(nums));
	}
}
