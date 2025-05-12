package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2094. 找出 3 位偶数
 */
public class FindEvenNumbers {

	public int[] findEvenNumbers(int[] digits) {
		List<Integer> result = new ArrayList<>();
		int[] count = new int[10];
		for (int digit : digits) {
			count[digit]++;
		}
		for (int i = 100; i <= 998; i += 2) {
			int[] pattern = new int[10];
			int t = i;
			while (t != 0) {
				pattern[t % 10]++;
				t /= 10;
			}
			int j = 0;
			for (; j < 10; ++j) {
				if (count[j] < pattern[j]) {
					break;
				}
			}
			if (j == 10) {
				result.add(i);
			}
		}
		return result.stream().mapToInt(i->i).toArray();
	}

	public static void main(String[] args) {
		int[] nums = {2,1,3,0};
		FindEvenNumbers findEvenNumbers = new FindEvenNumbers();
		System.out.println(Arrays.toString(findEvenNumbers.findEvenNumbers(nums)));
	}
}
