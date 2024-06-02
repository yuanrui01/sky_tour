package org.contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: yuanrui
 */
public class Case2024060203 {

	static class Node {
		char c;
		int index;

		public Node(char c, int index ) {
			this.c = c;
			this.index = index;
		}

		@Override
		public String toString() {
			return String.format("Node(c=%s,index=%s)", c, index);
		}
	}


	public String clearStars(String s) {
		int n = s.length();
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean[] flags = new boolean[n];
		Arrays.fill(flags, true);
		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node) -> node.c).thenComparing(node -> node.index, (i1, i2) -> Integer.compare(i2, i1)));

		for (int i = 0; i < charArray.length; ++i) {
			if (charArray[i] == '*') {
				flags[i] = false;
				Node poll = queue.poll();
				flags[poll.index] = false;
			} else {
				queue.add(new Node(charArray[i], i));
			}
		}

		for (int i = 0; i < n; ++i) {
			if (flags[i])
				sb.append(charArray[i]);
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		String s = "abc";
		Case2024060203 case2024060203 = new Case2024060203();

		System.out.println(case2024060203.clearStars(s));
	}
}
