package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 6. Z 字形变换
 */
public class Convert {
    public String convert(String s, int numRows) {
        List<Character>[] ila = new List[numRows];
        Arrays.setAll(ila, e -> new ArrayList<>());
        int[] indexArr = getIndexArr(numRows, s.length());
        for (int i = 0; i < s.length(); ++i) {
            ila[indexArr[i]].add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> il : ila)
            for (Character character : il)
                sb.append(character);
        return sb.toString();
    }

    private int[] getIndexArr(int n, int m) {
        int[] indexArr = new int[m];
        int i = 0;
        while (i < m) {
            for (int j = 0; i < m && j < n; j++,i++)
                indexArr[i] = j;
            for (int j = n - 2; i < m && j > 0; j--,i++)
                indexArr[i] = j;
        }
        return indexArr;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        Convert convert = new Convert();
        System.out.println(convert.convert(s, numRows));
    }
}
