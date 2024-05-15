package org.hypnos;

public class Tribonacci {


    public int tribonacci(int n) {
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < 40; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }
}
