package org.hypnos;


/**
 * 1191. K 次串联后最大子数组之和
 */
public class KConcatenationMaxSum {

    private static final int LIMIT = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int ans = 0;
        int sum = 0;
        int fullSum = 0;

        int leftAns = 0;
        int leftSum = 0;

        for (int value : arr) {
            if (leftSum + value >= LIMIT) {
                leftSum = (leftSum + value) % LIMIT;
                leftAns = leftSum;
            } else {
                leftSum += value;
                leftAns = Math.max(leftAns, leftSum);
            }

            if (sum + value >= LIMIT) {
                sum = (sum + value) % LIMIT;
                ans = sum;
            } else {
                sum += value;
                ans = Math.max(ans, sum);
            }

            fullSum = (fullSum + value) % LIMIT;
            if (sum < 0)
                sum = 0;
        }

        int rightAns = 0;
        int rightSum = 0;
        for (int i = arr.length - 1; i >= 0; --i) {
            if (rightSum + arr[i] >= LIMIT) {
                rightSum = (rightSum + arr[i]) % LIMIT;
                rightAns = rightSum;
            } else {
                rightSum += arr[i];
                rightAns = Math.max(rightAns, rightSum);
            }
        }
        if (leftAns + rightAns > ans && k > 1) {
            long mid = (fullSum * 1L *(k - 2)) % LIMIT;
            mid = mid > 0 ? mid : 0;
            return (int) ((leftAns + rightAns + mid) % LIMIT);
        } else {
            return ans;
        }
    }


    public static void main(String[] args) {
        int[] arr = {-9,13,4,-16,-12,-16,3,-7,5,-16,16,8,-1,-13,15,3};
        int k = 6;
        KConcatenationMaxSum kConcatenationMaxSum = new KConcatenationMaxSum();
        System.out.println(kConcatenationMaxSum.kConcatenationMaxSum(arr, k));
    }
}
