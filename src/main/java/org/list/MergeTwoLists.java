package org.list;

import org.common.ListNode;


/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumb = new ListNode(0);
        ListNode head = dumb;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        while (list1 != null) {
            head.next = list1;
            list1 = list1.next;
            head = head.next;
        }
        while (list2 != null) {
            head.next = list2;
            list2 = list2.next;
            head = head.next;
        }
        return dumb.next;
    }
}
