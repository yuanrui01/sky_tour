package org.list;

import org.common.ListNode;

import java.util.*;

/**
 * 206. 反转链表
 */
public class ReverseList {

	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		Deque<ListNode> stack = new ArrayDeque<>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		ListNode dumb = new ListNode();
		dumb.next = stack.pop();
		ListNode tmp = dumb.next;
		while (!stack.isEmpty()) {
			tmp.next = stack.pop();
			tmp = tmp.next;
			tmp.next = null;
		}
		return dumb.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;

		ReverseList reverseList = new ReverseList();
		reverseList.reverseList(node1);
	}
}
