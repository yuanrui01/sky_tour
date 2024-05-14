package org.hypnos;

public class MaxValue {

    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(n, index, maxSum, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return check(n, index, maxSum, left) ? left : left - 1;
    }


    private boolean check(int n, int index, int maxSum, int maxElem) {
        long sum = 0;
        if (maxElem == 1)
            return true;
        if (index >= 0) {
            if (index >= maxElem) {
                sum += (maxElem * (1L + maxElem)) / 2;
                sum += (index - maxElem + 1);
            } else {
                sum += (index + 1) * (2L * maxElem - index) / 2;
            }
        }

        if (index < n - 1) {
            if (index + maxElem <= n - 1) {
                sum += (maxElem * (1L + maxElem)) / 2;
                sum -= maxElem;
                sum += (n - index - maxElem);
            } else {
                sum += (n - index) * (2L * maxElem - n + index + 1) / 2;
                sum -= maxElem;
            }
        }

        return sum <= maxSum;
    }

    public static void main(String[] args) {
        int n = 5;
        int index = 0;
        int maxSum = 28;

        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.maxValue(n, index, maxSum));
    }
}
