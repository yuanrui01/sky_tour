package org.hypnos;


/**
 * 2595. 奇偶位数
 */
public class EvenOddBit {

    public int[] evenOddBit(int n) {
        int[] a = new int[2];
        int i = 0;
        while (n != 0) {
            a[i & 1] += n & 1;
            n >>= 1;
            i++;
        }
        return a;
    }
}
