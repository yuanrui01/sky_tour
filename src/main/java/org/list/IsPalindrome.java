package org.list;

import org.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LCR 027. 回文链表
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        for (int i = 0; i < n / 2; ++i) {
            if (!Objects.equals(list.get(i), list.get(n - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
