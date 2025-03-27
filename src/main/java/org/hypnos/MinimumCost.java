package org.hypnos;


/**
 * 2712. 使所有字符相等的最小成本
 */
public class MinimumCost {

    public long minimumCost(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        long ans0 = 0;
        long ans1 = 0;
        boolean b0 = false;
        boolean b1 = false;
        int s1 = n/2 - 1;
        int s2 = n/2;
        while (s1 >= 0) {
            if (arr[s1] == '0' && !b1 || arr[s1] == '1' && b1) {
                ans1 += (s1 + 1);
                b1 = !b1;
            }
            if (arr[s1] == '1' && !b0 || arr[s1] == '0' && b0){
                ans0 += (s1 + 1);
                b0 = !b0;
            }
            s1--;
        }
        b0 = b1 = false;
        while (s2 < n) {
            if (arr[s2] == '0' && !b1 || arr[s2] == '1' && b1) {
                ans1 += (n - s2);
                b1 = !b1;
            }
            if (arr[s2] == '1' && !b0 || arr[s2] == '0' && b0){
                ans0 += (n - s2);
                b0 = !b0;
            }
            s2++;
        }
        return Math.min(ans0, ans1);
    }

    public static void main(String[] args) {
        MinimumCost minimumCost = new MinimumCost();
        System.out.println(minimumCost.minimumCost("11"));
    }
}
