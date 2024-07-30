package org.hypnos;


import java.util.ArrayList;
import java.util.List;

/**
 * 2961. 双模幂运算
 */
public class GetGoodIndices {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < variables.length; ++i) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            if (fastPower(fastPower(a, b, 10), c, m) == target)
                ans.add(i);
        }
        return ans;
    }

    private int fastPower(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }
}
