package org.hypnos;


/**
 * 3280. 将日期转换为二进制表示
 */
public class ConvertDateToBinary {

    public String convertDateToBinary(String date) {
        String[] arr = date.split("-");
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        return Integer.toBinaryString(y) + "-" + Integer.toBinaryString(m) + "-" + Integer.toBinaryString(d);
    }
}
