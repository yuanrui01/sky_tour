package org.hypnos;


/**
 * 1191. K 次串联后最大子数组之和
 */
public class KConcatenationMaxSum {

    private static final int LIMIT = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int leftAns = 0;
        int leftSum = 0;
        int rightSum = 0;
        int rightAns = 0;
        int singleSum = 0;
        int singleAns = 0;
        for(int i = 0; i < n; ++i) {
            int left = arr[i];
            int right = arr[n - i - 1];
            leftSum += left;
            rightSum += right;
            singleSum += left;
            singleAns = Math.max(singleAns, singleSum);
            if (singleSum < 0)
                singleSum = 0;
            leftAns = Math.max(leftAns, leftSum);
            rightAns = Math.max(rightAns, rightSum);
        }
        if (k == 1)
            return singleAns;
        int deq = leftAns + rightAns;
        leftSum = Math.max(leftSum, 0);
        if (singleAns >= deq)
            return singleAns;
        else
            return (int)((deq + (long)(k - 2) * leftSum) % LIMIT);
    }


    public static void main(String[] args) {
        int[] arr = {-9,13,4,-16,-12,-16,3,-7,5,-16,16,8,-1,-13,15,3};
        int k = 6;
        KConcatenationMaxSum kConcatenationMaxSum = new KConcatenationMaxSum();
        System.out.println(kConcatenationMaxSum.kConcatenationMaxSum(arr, k));
    }
}
