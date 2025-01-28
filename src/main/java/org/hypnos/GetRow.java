package org.hypnos;

import java.util.ArrayList;
import java.util.List;


/**
 * 119. 杨辉三角 II
 */
public class GetRow {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i <= rowIndex; ++i) {
            List<Integer> l = new ArrayList<>();
            List<Integer> p = result.get(i - 1);
            l.add(1);
            for (int j = 0; j < p.size() - 1; ++j) {
                l.add(p.get(j) + p.get(j+1));
            }
            l.add(1);
            result.add(l);
        }
        return result.get(rowIndex);
    }
}
