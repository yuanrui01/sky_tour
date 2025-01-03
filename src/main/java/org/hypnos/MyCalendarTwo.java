package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. 我的日程安排表 II
 * @author: yuanrui
 */
public class MyCalendarTwo {

	private List<int[]> booked;

	public MyCalendarTwo() {
		booked = new ArrayList<>();
	}

	public boolean book(int startTime, int endTime) {
		List<int[]> overlap = new ArrayList<>();
		for (int[] book : booked) {
			int l = book[0];
			int r = book[1];
			if (r > startTime && l < endTime) {
				for (int[] range : overlap) {
					if (range[1] > l && range[0] < r) {
						return false;
					}
				}
				overlap.add(new int[]{Math.max(startTime, l), Math.min(endTime, r)});
			}
		}
		booked.add(new int[]{startTime, endTime});
		return true;
	}

	public static void main(String[] args) {
		MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
		List<Integer> integers = List.of(10, 20, 50, 60, 10, 40, 5, 15, 5, 10, 25, 55);
		int size = integers.size();
		for (int i = 0; i < size; i += 2) {
			int startTime = integers.get(i);
			int endTime  =integers.get(i + 1);
			System.out.println(myCalendarTwo.book(startTime, endTime));
		}
//
//		myCalendarTwo.book(10, 20);
//		myCalendarTwo.book(50, 60);
//		myCalendarTwo.book(10, 40);
//		myCalendarTwo.book(5, 15);
//		myCalendarTwo.book(5, 10);
//		myCalendarTwo.book(25, 55);
	}
}
