package org.list;

import org.common.ListNode;

/**
 * LCR 027. 回文链表
 */
public class IsPalindrome {

    // 先求出中间节点，然后对中间节点进行反转，之后顺序比较
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = findMiddleNode(head);
        ListNode head2 = reverse(middleNode);
        while (head2 != null) {
            if (head2.val != head.val) {
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
