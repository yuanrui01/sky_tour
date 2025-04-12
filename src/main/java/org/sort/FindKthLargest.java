package org.sort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {

	public int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		return quickFind(nums, 0, n - 1, n, k);
	}

	private int quickFind(int[] nums, int l, int r, int n, int k) {
		if (l >= r) return nums[l];
		int p = partition(nums, l, r);
		if (p == n-k) return nums[p];
		if (p > n - k) {
			return quickFind(nums, l, p-1, n, k);
		} else {
			return quickFind(nums, p + 1, r, n, k);
		}
	}

	private int partition(int[] a, int l, int r) {
		int i = l;
		int j = r + 1;
		int v = a[l];
		while (true) {
			while (a[++i] < v && i != r) ;
			while (a[--j] > v && j != l) ;
			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, j, l);
		return j;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("E:\\MyJavaProjects\\spring-boot\\spring-boot-project\\sky_tour\\src\\main\\java\\org\\sort\\nums.txt")));
		String[] ns = content.split(",");
		int[] nums = new int[ns.length];
		for (int i = 0; i < nums.length; ++i) {
			nums[i] = Integer.parseInt(ns[i]);
		}
		int k = 50000;
		FindKthLargest findKthLargest = new FindKthLargest();
		System.out.println(findKthLargest.findKthLargest(nums, k));
	}
}
