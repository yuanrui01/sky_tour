package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. 我的日程安排表 I
 */
public class MyCalendar {

    public List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<>();
    }

    // if
    public boolean book(int startTime, int endTime) {
        for (int[] book : booked) {
            if (book[0] < endTime && startTime < book[1]) {
                return false;
            }
        }
        booked.add(new int[]{startTime, endTime});
        return true;
    }
}
