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

    public String convertDateToBinary2(String date) {
        String[] arr = date.split("-");
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        return i2s(y) + "-" + i2s(m) + "-" + i2s(d);
    }

    private String i2s(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
