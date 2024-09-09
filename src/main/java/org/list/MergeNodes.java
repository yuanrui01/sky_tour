package org.list;

import org.common.ListNode;

/**
 * 2181. 合并零之间的节点
 * @author yuanrui
 */
public class MergeNodes {

	public ListNode mergeNodes(ListNode head) {
		int sum = 0;
		ListNode hd = new ListNode();
		ListNode cur = new ListNode(0);
		hd.next = cur;
		while (head.next != null) {
			head = head.next;
			if (head.val != 0) {
				sum += head.val;
			} else if (head.next != null) {
				cur.val = sum;
				cur.next = new ListNode(0);
				cur = cur.next;
				sum = 0;
			} else {
				cur.val = sum;
			}
		}
		return hd.next;
	}
}
