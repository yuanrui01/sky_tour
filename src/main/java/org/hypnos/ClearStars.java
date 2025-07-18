package org.hypnos;


import java.util.*;

/**
 * 3170. 删除星号以后字典序最小的字符串
 */
public class ClearStars {

    public String clearStars(String S) {
        char[] s = S.toCharArray();
        ArrayDeque<Integer>[] stacks = new ArrayDeque[26];
        Arrays.setAll(stacks, k -> new ArrayDeque<>());
        for (int i = 0; i < s.length; ++i) {
            if (s[i] != '*') {
                stacks[s[i] - 'a'].add(i);
                continue;
            }
            for (ArrayDeque<Integer> stack : stacks) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                    break;
                }
            }
        }
        List<Integer> idxs = new ArrayList<>();
        for (ArrayDeque<Integer> stack : stacks) {
            idxs.addAll(stack);
        }
        Collections.sort(idxs);
        StringBuilder sb = new StringBuilder();
        for (Integer idx : idxs) {
            sb.append(s[idx]);
        }
        return sb.toString();
    }
}
