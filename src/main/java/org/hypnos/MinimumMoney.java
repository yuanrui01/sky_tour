package org.hypnos;


/**
 * 2412. 完成所有交易的初始最少钱数
 */
public class MinimumMoney {


    public long minimumMoney(int[][] trans) {
        long ans = 0L;
        int mx = 0;
        for (int[] tran : trans) {
            ans += Math.max(0, tran[0] - tran[1]);
            mx = Math.max(mx, Math.min(tran[0], tran[1]));
        }
        return ans + mx;
    }

    public static void main(String[] args) {
        MinimumMoney minimumMoney = new MinimumMoney();
        int[][] transactions = {{13,99},{14,76},{18,61},{50,96},{49,63},{16,98},{37,19},{87,32},{100,98},{98,26},{86,99},{76,20},{5,61},{14,20},{21,83},{33,53},{75,86},{40,62},{71,14},{62,61},{34,29},{66,40},{37,39},{14,88},{79,53},{53,84},{63,58},{79,27},{24,58},{93,58},{56,12},{8,70},{14,76},{58,63},{62,38},{7,33},{74,22},{93,77},{74,60},{64,86},{75,89},{58,29},{85,65},{50,78},{51,14},{97,92},{98,97},{37,75},{35,1},{54,26},{48,28},{2,0},{10,20},{0,31},{8,55},{59,53},{71,21},{8,85},{27,48},{26,100},{86,20},{26,66},{77,18},{50,1},{59,98},{6,11},{14,28},{99,95},{17,49},{18,10},{54,55},{73,7},{50,82},{73,41},{78,43},{67,91},{59,62},{100,49}};
        //int[][] transactions = {{6,5},{0,5},{8,5},{3,6},{9,0},{10,1},{4,10}};
        System.out.println(minimumMoney.minimumMoney(transactions));
    }
}
