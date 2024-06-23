package org.hypnos;

import java.util.Arrays;

/**
 * 503. 下一个更大元素 II
 */
public class NextGreaterElements {

	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		Deque<Integer> stack = new LinkedList<>();
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		for (int i = 0; i < 2*n - 1; ++i) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n])
				ans[stack.pop()] = nums[i%n];
			stack.push(i%n);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};

		NextGreaterElements nextGreaterElements = new NextGreaterElements();
		System.out.println(nextGreaterElements.nextGreaterElements(nums));
	}
}
