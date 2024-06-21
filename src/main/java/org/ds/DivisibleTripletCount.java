package org.ds;


import java.util.HashMap;
import java.util.Map;

/**
 * 2964. 可被整除的三元组数量
 */
public class DivisibleTripletCount {

    public int divisibleTripletCount(int[] nums, int d) {
        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i < n; ++i) {
            for (int j = i - 2; j >= 0; --j)
                map.merge((nums[i - 1] + nums[j]) % d, 1, Integer::sum);
            ans += map.getOrDefault((d - (nums[i] % d)) % d, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        DivisibleTripletCount divisibleTripletCount = new DivisibleTripletCount();
        int[] nums = {3,3,3,3};
        int d = 3;
        System.out.println(divisibleTripletCount.divisibleTripletCount(nums, d));
    }
}
