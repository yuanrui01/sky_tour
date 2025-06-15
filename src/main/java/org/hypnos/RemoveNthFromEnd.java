package org.hypnos;

import org.common.ListNode;

/**
 * LCR 021. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dump = new ListNode(0, head);
		ListNode left = dump;
		ListNode right = dump;
		while (n-- > 0) {
			right = right.next;
		}
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return dump.next;
	}
}
