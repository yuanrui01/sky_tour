package org.list;

import org.common.ListNode;

/**
 * 206. 反转链表
 */
public class ReverseList {

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		while (head != null) {
		    next = head.next;
		    head.next = prev;
		    prev = head;
		    head = next;
		}
		return prev;
	}
	
	public ListNode reverseList2(ListNode head) {
		return head == null ? null : reverse(null, head);
	}
	
	public ListNode reverse(ListNode parent, ListNode child) {
		ListNode next = child.next;
		child.next = parent;
		return next == null ? child : reverse(child, next);
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;

		ReverseList reverseList = new ReverseList();
		reverseList.reverseList(node1);
	}
}
