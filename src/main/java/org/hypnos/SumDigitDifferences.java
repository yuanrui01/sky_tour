package org.hypnos;

import java.util.*;


/**
 * 3153. 所有数对中数位不同之和
 */
public class SumDigitDifferences {

    public long sumDigitDifferences(int[] nums) {
        int digits = getDigits(nums[0]);
        long[][] count = new long[digits][10];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < digits; ++j) {
                count[j][nums[i] % 10]++;
                nums[i] /= 10;
            }
        }
        long ans = 0L;
        for (int i = 0; i < digits; ++i) {
            long[] longs = count[i];
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < 10; ++j) {
                if (longs[j] != 0)
                    list.add(longs[j]);
            }
            if (!list.isEmpty()) {
                for (int j = 0; j < list.size() - 1; ++j) {
                    for (int k = j + 1; k < list.size(); ++k) {
                        ans += list.get(j) * list.get(k);
                    }
                }
            }
        }
        return ans;
    }

    private int getDigits(int num) {
        int ans = 0;
        while (num != 0) {
            num /= 10;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SumDigitDifferences sumDigitDifferences = new SumDigitDifferences();
        int[] nums = {13,23,12};
        System.out.println(sumDigitDifferences.sumDigitDifferences(nums));
    }
}
