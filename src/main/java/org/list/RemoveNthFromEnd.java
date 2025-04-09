package org.list;

import org.common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumb = new ListNode(0);
        ListNode p = dumb;
        dumb.next = head;
        for (int i = 0; i < n; ++i) {
            head = head.next;
        }
        while (head != null) {
            p = p.next;
            head = head.next;
        }
        p.next = p.next.next;
        return dumb.next;
    }
}
