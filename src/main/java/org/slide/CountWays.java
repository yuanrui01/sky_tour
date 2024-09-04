package org.slide;

import java.util.Arrays;
import java.util.List;


/**
 * 2860. 让所有学生保持开心的分组方法数
 */
public class CountWays {

    public int countWays(List<Integer> nums) {
        int[] a = nums.stream().mapToInt(i -> i).toArray();
        Arrays.sort(a);
        int ans = a[0] > 0 ? 1 : 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < i && i < a[i]) {
                ans++;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        CountWays countWays = new CountWays();
        List<Integer> integers = List.of(1, 7);
        System.out.println(countWays.countWays(integers));
    }
}
