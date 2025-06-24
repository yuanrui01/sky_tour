package org.hypnos;

import java.util.ArrayList;
import java.util.List;


/**
 * 2200. 找出数组中的所有 K 近邻下标
 */
public class FindKDistantIndices {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> ps = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] == key) {
                ps.add(i);
            }
        }
        boolean[] marks = new boolean[n];
        for (int i = 0; i < ps.size(); ++i) {
            int xi = ps.get(i);
            marks[xi] = true;
            xi--;
            while (xi >=0 && ps.get(i) - xi <= k) {
                marks[xi] = true;
                xi--;
            }
            xi = ps.get(i) + 1;
            while (xi < n && xi - ps.get(i) <= k) {
                marks[xi] = true;
                xi++;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (marks[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {734,228,636,204,552,732,686,461,973,874,90,537,939,986,855,387,344,939,552,389,116,93,545,805,572,306,157,899,276,479,337,219,936,416,457,612,795,221,51,363,667,112,686,21,416,264,942,2,127,47,151,277,603,842,586,630,508,147,866,434,973,216,656,413,504,360,990,228,22,368,660,945,99,685,28,725,673,545,918,733,158,254,207,742,705,432,771,578,549,228,766,998,782,757,561,444,426,625,706,946};
        int key = 939;
        int k = 34;
        FindKDistantIndices findKDistantIndices = new FindKDistantIndices();
        System.out.println(findKDistantIndices.findKDistantIndices(nums, key, k));
    }
}
