package org.hypnos;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 */
public class NextGreaterElements {

	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int n2 = 2 * n - 1;
		int[] ans = new int[n];
		Deque<Integer> stack = new LinkedList<>();
		for(int i = n2; i >= 0; --i) {
			while(!stack.isEmpty() && stack.peek() < nums[i % n])
				stack.pop();
			if (stack.isEmpty())
				ans[i % n] = -1;
			else
				ans[i % n] = stack.peek();
			stack.push(nums[i % n]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};

		NextGreaterElements nextGreaterElements = new NextGreaterElements();
		System.out.println(nextGreaterElements.nextGreaterElements(nums));
	}
}
