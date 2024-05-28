package org.test;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (String query: queries) {
            for (String word : dictionary) {
                int n = word.length();
                int diffCount = 0;
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    if (query.charAt(i) != word.charAt(i)) {
                        diffCount++;
                        if (diffCount == 3) {
                            break;
                        }
                    }
                }
                if (diffCount <= 2) {
                    list.add(query);
                    break;
                }
            }
        }
        return list;
    }
}
