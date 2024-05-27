package org.hypnos;


/**
 * 1052. 爱生气的书店老板
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int length = customers.length;
        int[] unsatisfied = new int[length];
        int sum = 0;
        int unsatisfiedCount = 0;
        for (int i = 0; i < length; i++) {
            sum += customers[i];
            if (grumpy[i] == 1) {
                unsatisfied[i] = customers[i];
                unsatisfiedCount += customers[i];
            } else {
                unsatisfied[i] = 0;
            }
        }

        int cnt = 0;
        for (int i = 0; i < minutes; ++i)
            cnt += unsatisfied[i];

        int saved = cnt;
        for (int i = minutes; i < length; ++i) {
            cnt += unsatisfied[i];
            cnt -= unsatisfied[i - minutes];
            saved = Math.max(saved, cnt);
        }
        return sum - unsatisfiedCount + saved;
    }

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        MaxSatisfied maxSatisfied = new MaxSatisfied();
        System.out.println(maxSatisfied.maxSatisfied(customers, grumpy, minutes));
    }
}
