package org.hypnos;

import java.util.ArrayList;
import java.util.List;


/**
 * 2900. 最长相邻不相等子序列 I
 */
public class GetLongestSubsequence {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i == n - 1 || groups[i] != groups[i + 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"e", "a", "b"};
        int[] groups = {0, 0, 1};
        GetLongestSubsequence getLongestSubsequence = new GetLongestSubsequence();
        System.out.println(getLongestSubsequence.getLongestSubsequence(words, groups));
    }
}
