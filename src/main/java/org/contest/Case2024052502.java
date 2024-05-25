package org.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yuanrui
 */
public class Case2024052502 {


	public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
		int[] ans = new int[queries.length];
		List<Integer> xList = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == x) {
				xList.add(i);
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int y = queries[i];
			if (y > xList.size()) {
				ans[i] = -1;
			} else {
				ans[i] = xList.get(y - 1);
			}
		}

		return ans;
	}


	public static void main(String[] args) {


		int[] nums = {1,2,3};
		int[] queries = {10};
		int x = 5;
		int[] ints = new Case2024052502().occurrencesOfElement(nums, queries, x);
		System.out.println(Arrays.toString(ints));
	}

}
