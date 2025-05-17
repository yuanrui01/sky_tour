package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 2901. 最长相邻不相等子序列 II
 */
public class GetWordsInLongestSubsequence {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] f = new int[n];
        int[] from = new int[n];
        int maxI = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 提前比较 f[j] 与 f[i] 的大小，如果 f[j] <= f[i]，就不用执行更耗时的 check 了
                if (f[j] > f[i] && groups[j] != groups[i] && check(words[i], words[j])) {
                    f[i] = f[j];
                    from[i] = j;
                }
            }
            f[i]++; // 加一写在这里
            if (f[i] > f[maxI]) {
                maxI = i;
            }
        }

        int i = maxI;
        int m = f[i];
        List<String> ans = new ArrayList<>(m); // 预分配空间
        for (int k = 0; k < m; k++) {
            ans.add(words[i]);
            i = from[i];
        }
        return ans;
    }

    private boolean check(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        boolean diff = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (diff) { // 汉明距离大于 1
                    return false;
                }
                diff = true;
            }
        }
        return diff;
    }
}
