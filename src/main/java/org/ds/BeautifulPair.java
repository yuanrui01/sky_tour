package org.ds;


/**
 * 2613. 美数对
 *
 */
public class BeautifulPair {

    public int[] beautifulPair(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] n1 = new int[len];
        int[] n2 = new int[len];

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int max1 = nums1[0] + nums2[0];
        int max2 = nums1[0] - nums2[0];
        for (int i = 1; i < len; ++i) {
            int tt1 = nums1[i] + nums2[i];
            int tt2 = nums1[i] - nums2[i];

            ans1 = Math.min(ans1, Math.abs(tt1 - max1));
            ans2 = Math.min(ans2, Math.abs(tt2 - max2));
            max1 = Math.max(max1, tt1);
            max2 = Math.max(max2, tt2);
        }
        System.out.println(Math.min(ans1, ans2));
        return new int[]{1,1};
    }

    public static void main(String[] args) {
        BeautifulPair beautifulPair = new BeautifulPair();
        int[] nums1 = {1,2,3,2,4};
        int[] nums2 = {2,3,1,2,3};
        beautifulPair.beautifulPair(nums1, nums2);
    }
}
