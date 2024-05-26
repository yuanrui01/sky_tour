package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024052601 {

	public int numberOfPairs(int[] nums1, int[] nums2, int k) {
		int ans = 0;
		for(int i = 0; i < nums2.length; i++) {
			int c = nums2[i] * k;
			for (int j = 0; j < nums1.length; j++) {
				if (nums1[j] % c == 0) {
					ans++;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums1 ={1,2,4,12};
		int[] nums2 ={2,4};
		int k = 3;
		int i = new Case2024052601().numberOfPairs(nums1, nums2, k);
		System.out.println(i);
	}
}
