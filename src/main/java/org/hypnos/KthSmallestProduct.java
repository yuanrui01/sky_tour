package org.hypnos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2040. 两个有序数组的第 K 小乘积
 */
public class KthSmallestProduct {

	public long kthSmallestProduct(int[] a, int[] b, long k) {
		int i0 = lowerBound(a, 0); // 四个区域的水平分界线
		int j0 = lowerBound(b, 0); // 四个区域的垂直分界线

		int n = a.length;
		int m = b.length;
		List<Long> corners = Arrays.asList((long) a[0] * b[0], (long) a[0] * b[m - 1], (long) a[n - 1] * b[0], (long) a[n - 1] * b[m - 1]);
		long left = Collections.min(corners) - 1;
		long right = Collections.max(corners);

		while (left + 1 < right) {
			long mid = left + (right - left) / 2;
			if (check(a, b, i0, j0, k, mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}

	private boolean check(int[] a, int[] b, int i0, int j0, long k, long mx) {
		int n = a.length;
		int m = b.length;
		long cnt = 0;

		if (mx < 0) {
			// 右上区域
			int i = 0;
			int j = j0;
			while (i < i0 && j < m) { // 不判断 cnt < k 更快
				if ((long) a[i] * b[j] > mx) {
					j++;
				} else {
					cnt += m - j;
					i++;
				}
			}

			// 左下区域
			i = i0;
			j = 0;
			while (i < n && j < j0) {
				if ((long) a[i] * b[j] > mx) {
					i++;
				} else {
					cnt += n - i;
					j++;
				}
			}
		} else {
			// 右上区域和左下区域的所有数都 <= 0 <= mx
			cnt = (long) i0 * (m - j0) + (long) (n - i0) * j0;

			// 左上区域
			int i = 0;
			int j = j0 - 1;
			while (i < i0 && j >= 0) {
				if ((long) a[i] * b[j] > mx) {
					i++;
				} else {
					cnt += i0 - i;
					j--;
				}
			}

			// 右下区域
			i = i0;
			j = m - 1;
			while (i < n && j >= j0) {
				if ((long) a[i] * b[j] > mx) {
					j--;
				} else {
					cnt += j - j0 + 1;
					i++;
				}
			}
		}

		return cnt >= k;
	}

	private int lowerBound(int[] nums, int target) {
		int left = -1;
		int right = nums.length;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}
}
