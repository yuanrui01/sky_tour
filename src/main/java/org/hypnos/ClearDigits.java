package org.hypnos;


import java.util.Arrays;

/**
 * 3174. 清除数字
 */
public class ClearDigits {

    public String clearDigits(String s) {
        char[] srr = s.toCharArray();
        boolean[] bs = new boolean[srr.length];
        Arrays.fill(bs, true);
        for (int i = 0; i < srr.length; ++i) {
            if (srr[i] >= '0' && srr[i] <= '9') {
                bs[i] = false;
                int j = i - 1;
                while (j >= 0) {
                    if (srr[j] >= 'a' && srr[j] <= 'z' && bs[j]) {
                        bs[j] = false;
                        break;
                    }
                    j--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bs.length; ++i) {
            if (bs[i]) {
                sb.append(srr[i]);
            }
        }
        return sb.toString();
    }
}
