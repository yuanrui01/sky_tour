package org.hypnos;


import java.util.*;

/**
 * 2306. 公司命名
 */
public class DistinctNames {


    public long distinctNames(String[] ideas) {
        Set<String>[] sets = new Set[26];
        Arrays.setAll(sets, e -> new HashSet<>());
        for (String idea : ideas) {
            sets[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long ans = 0;
        for (int i = 1; i < 26; ++i) {
            for (int j = 0; j < i; ++j) {
                int common = 0;
                for (String s : sets[i])
                    if (sets[j].contains(s))
                        common++;
                ans += (long) (sets[i].size() - common) * (sets[j].size() - common);
            }
        }
        return ans * 2;
    }


    public long distinctNames2(String[] ideas) {
        int[] size = new int[26];
        int[][] common = new int[26][26];
        Map<String, Integer> groups = new HashMap<>();
        for (String idea : ideas) {
            int b = idea.charAt(0) - 'a';
            size[b]++;
            String suffix = idea.substring(1);
            int mask = groups.getOrDefault(suffix, 0);
            groups.put(suffix, mask | 1 << b);
            for (int a = 0; a < 26; a++) {
                if ((mask >> a & 1) > 0) {
                    common[a][b]++;
                    common[b][a]++;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i < 26; ++i) {
            for (int j = 0; j < i; ++j) {
                int m = common[i][j];
                ans += (long) (size[i] - m) * (size[j] - m);
            }
        }
        return ans * 2;
    }

    public static void main(String[] args) {
        String[] ideas = {"coffee","donuts","time","toffee"};
        DistinctNames distinctNames = new DistinctNames();
        System.out.println(distinctNames.distinctNames(ideas));
        System.out.println(1 << 0);
    }
}
