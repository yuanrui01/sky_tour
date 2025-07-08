package org.design;

import java.util.Arrays;

public class BMTest {

    private static final int SIZE = 256;


    private void generateBC(char[] b, int m, int [] bc) {
        Arrays.fill(bc, -1);
        for (int i = 0; i < m; ++i) {
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) {
                if (a[i+j] != b[j]) break;
            }
            if (j < 0) {
                return i;
            }
            i = i + (j - bc[a[i+j]]);
        }
        return -1;
    }
}
