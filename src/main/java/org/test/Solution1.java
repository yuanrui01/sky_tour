package org.test;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (String query: queries) {
            if (isValid(query, dictionary))
                list.add(query);
        }
        return list;
    }

    private boolean isValid(String query, String[] dictionary) {
        for (String word : dictionary) {
            int diffCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (query.charAt(i) != word.charAt(i)) {
                    diffCount++;
                    if (diffCount > 2) {
                        break;
                    }
                }
            }
            if (diffCount <= 2) {
                return true;
            }
        }
        return false;
    }
}