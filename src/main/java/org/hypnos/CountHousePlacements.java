package org.hypnos;


/**
 * 2320. 统计放置房子的方式数
 */
public class CountHousePlacements {

    private static final int LIMIT = 1000000007;

    public int countHousePlacements(int n) {
        long f0 = 1;
        long f1 = 1;
        for (int i = 1; i <= n; i++) {
            long newF = (f0 + f1) % LIMIT;
            f0 = f1;
            f1 = newF;
        }
        return (int) ((f1 * f1) % LIMIT);
    }

    public static void main(String[] args) {
        int n = 2;
        CountHousePlacements countHousePlacements = new CountHousePlacements();
        System.out.println(countHousePlacements.countHousePlacements(n));
    }
}
