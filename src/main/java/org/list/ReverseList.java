package org.list;

import org.common.ListNode;

/**
 * 206. 反转链表
 */
public class ReverseList {

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;

		ReverseList reverseList = new ReverseList();
		reverseList.reverseList(node1);
	}
}
