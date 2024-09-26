package org.hypnos;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        String[] ideas = {"coffee","donuts","time","toffee"};
        DistinctNames distinctNames = new DistinctNames();
        System.out.println(distinctNames.distinctNames(ideas));
    }
}
