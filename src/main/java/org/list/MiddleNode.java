package org.list;

import org.common.ListNode;


/**
 * 876. 链表的中间结点
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
