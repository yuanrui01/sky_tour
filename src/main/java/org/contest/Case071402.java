package org.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class Case071402 {

	public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

	public ListNode modifiedList(int[] nums, ListNode head) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, 1);
		ListNode t = new ListNode(0);
		t.next = head;
		ListNode preNode = t;
		ListNode curNode = head;
		while (curNode != null) {
			if (map.get(curNode.val) != null) {
				preNode.next = curNode.next;
			} else {
				preNode = curNode;
			}
			curNode = curNode.next;
		}
		return t.next;
	}

	public static void main(String[] args) {
		Case071402 case071402 = new Case071402();
		int[] nums = {1,2,3};
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next.next = new ListNode(6);
		ListNode listNode = case071402.modifiedList(nums, head);
		System.out.println(listNode);
	}
}
