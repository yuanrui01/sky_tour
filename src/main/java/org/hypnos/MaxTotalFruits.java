package org.hypnos;

/**
 * 2106. 摘水果
 */
public class MaxTotalFruits {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0;
        int sum = 0;
        int left = 0, right = 0;
        int n = fruits.length;
        for (int i = 0; i < n; ++i) {
            if (Math.abs(fruits[i][0] - startPos) <= k) {
                right = i;
                left = i;
                break;
            }
        }
        while (right < n && Math.abs(fruits[right][0] - startPos) <= k) {
            sum += fruits[right][1];
            int dist = (fruits[right][0] - fruits[left][0]) + Math.min(Math.abs(startPos - fruits[right][0]), Math.abs(startPos - fruits[left][0]));
            while (dist > k) {
                sum -= fruits[left][1];
                left++;
                dist =  (fruits[right][0] - fruits[left][0]) + Math.min(Math.abs(startPos - fruits[right][0]), Math.abs(startPos - fruits[left][0]));
            }
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] fruits = {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        int startPos = 5;
        int k = 4;
        MaxTotalFruits maxTotalFruits = new MaxTotalFruits();

        System.out.println(maxTotalFruits.maxTotalFruits(fruits, startPos, k));
    }
}
