package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024090801 {

	public String convertDateToBinary(String date) {
		String[] parts = date.split("-");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);
		String y = Integer.toBinaryString(year);
		String m = Integer.toBinaryString(month);
		String d = Integer.toBinaryString(day);
		return y + "-" + m + "-" + d;
	}


	public static void main(String[] args) {
		Case2024090801 case2024090801 = new Case2024090801();

	}
}
