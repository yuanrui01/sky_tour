package org.contest;

import java.util.*;

public class Case2024091503 {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // 将单词的所有前缀插入到 Trie 中
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.isEndOfWord = true;
            }
        }

        // 从给定位置开始查找目标字符串的所有可能前缀长度
        List<Integer> findAllPrefixes(String target, int start) {
            List<Integer> lengths = new ArrayList<>();
            TrieNode node = root;
            for (int i = start; i < target.length(); i++) {
                char c = target.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                if (node.isEndOfWord) {
                    lengths.add(i - start + 1);
                }
            }
            return lengths;
        }
    }

    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 构建 Trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // 动态规划
        for (int i = 0; i < n; ) {
            if (dp[i] == Integer.MAX_VALUE) {
                i++;
                continue;
            }

            // 查找从当前位置开始的所有可能的前缀长度
            List<Integer> prefixLengths = trie.findAllPrefixes(target, i);
            if (prefixLengths.isEmpty()) {
                i++;
                continue;
            }

            // 使用滑动窗口技术更新 DP 数组
            int maxLength = Collections.max(prefixLengths);
            for (int len : prefixLengths) {
                if (i + len <= n) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                }
            }

            // 跳跃到目标字符串的最远位置
            i += maxLength;
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }


    public static void main(String[] args) {
        String[] words = new String[]{"b","ccacc","a"};
        String target = "cccaaaacba";
        Case2024091503 case2024091503 = new Case2024091503();

        System.out.println(case2024091503.minValidStrings(words, target));
    }
}
