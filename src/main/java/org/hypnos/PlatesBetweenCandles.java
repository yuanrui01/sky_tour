package org.hypnos;

import java.util.Arrays;


/**
 * 2055. 蜡烛之间的盘子 - 前缀和
 */
public class PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        int[] left = new int[length];
        int[] right = new int[length];
        int[] prePlatesCount = new int[length];
        int[] ans = new int[queries.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] == '|') {
                right[i] = i;
            }
            if (i > 0)
                right[i - 1] = right[i];
        }
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == '|') {
                left[i] = i;
            }
            if (i < length - 1)
                left[i + 1] = left[i];
        }
        int begin = 0;
        int end = length - 1;
        while (begin <= length - 1) {
            if (charArray[begin] == '|')
                break;
            begin++;
        }
        if (begin == length - 1)
            return ans;
        while (end >= 0) {
            if (charArray[end] == '|')
                break;
            end--;
        }
        if (end == 0)
            return ans;
        int count = 0;
        for (int i = begin; i <= end; ++i) {
            if (charArray[i] == '*')
                count++;
            prePlatesCount[i] = count;
        }

        for (int i = 0; i < queries.length; ++i) {
            int x = queries[i][0];
            int y = queries[i][1];
            int reX = right[x];
            int reY = left[y];
            if (reX == -1 || reY == -1)
                continue;
            if (reX < reY)
                ans[i] = prePlatesCount[reY] - prePlatesCount[reX];
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "|*|*";
        int[][] queries = {{3,3}};
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        System.out.println(Arrays.toString(platesBetweenCandles.platesBetweenCandles(s, queries)));
    }
}
