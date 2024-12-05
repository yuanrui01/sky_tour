package org.list;

import org.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode tmpA = headA;
		ListNode tmpB = headB;
		Set<ListNode> set = new HashSet<>();
		while (tmpA != null) {
			set.add(tmpA);
			tmpA = tmpA.next;
		}
		while (tmpB != null) {
			if (set.contains(tmpB)) {
				return tmpB;
			}
			tmpB = tmpB.next;
		}
		return null;
	}
}
