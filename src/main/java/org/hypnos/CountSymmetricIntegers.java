package org.hypnos;


/**
 * 2843. 统计对称整数的数目
 */
public class CountSymmetricIntegers {

    private static int[] ans = new int[10001];
    private static int[] digit = new int[5];

    static {
        for (int i = 1; i < 10001; ++i) {
            ans[i] += ans[i-1] + (isSymmetric(i) ? 1 : 0);
        }
    }

    private static boolean isSymmetric(int i) {
        if (i < 10) return false;
        if (i > 99 && i < 1000) return false;
        int j = 0;
        while (i != 0) {
            digit[j++] = i % 10;
            i /= 10;
        }
        int s1 = 0;
        int s2 = 0;
       for (int k = 0; k < j / 2; ++k) {
           s1 += digit[k];
       }
       for (int k = j / 2; k < j; ++k) {
           s2 += digit[k];
       }
       return s1 == s2;
    }


    public int countSymmetricIntegers(int low, int high) {
        return ans[high] - ans[low-1];
    }

    public static void main(String[] args) {
        CountSymmetricIntegers countSymmetricIntegers = new CountSymmetricIntegers();
        System.out.println(countSymmetricIntegers.countSymmetricIntegers(100, 10000));
    }
}
