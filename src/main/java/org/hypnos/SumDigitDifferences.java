package org.hypnos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 3153. 所有数对中数位不同之和
 */
public class SumDigitDifferences {

    public long sumDigitDifferences(int[] nums) {
        int digits = getDigits(nums[0]);
        Map<Integer, Integer>[] count = new Map[digits];
        Arrays.setAll(count, e -> new HashMap<>());
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < digits; ++j) {
                count[j].merge(nums[i] % 10, 1, Integer::sum);
                nums[i] /= 10;
            }
        }
        long ans = 0L;
        for (int i = 0; i < digits; ++i) {
            Map<Integer, Integer> imap = count[i];
            if (imap.size() > 1) {
                int[] array = imap.values().stream().mapToInt(inte -> inte).toArray();
                for (int j = 0; j < array.length - 1; ++j) {
                    for (int k = j + 1; k < array.length; ++k) {
                        ans += (long) array[j] * array[k];
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
