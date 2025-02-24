package org.hypnos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1656. 设计有序流
 */
public class OrderedStream {

    private final int n;
    private final String[] ss;
    private int ptr;

    public OrderedStream(int n) {
        this.n = n+1;
        this.ss = new String[n+1];
        this.ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        ss[idKey] = value;
        if (ss[ptr] == null) {
            return Collections.emptyList();
        }
        List<String> ans = new ArrayList<>();
        for (int i = ptr; i < n; ++i) {
            if (ss[i] != null) {
                ans.add(ss[i]);
                ptr = i + 1;
            } else {
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // 插入 (3, "ccccc")，返回 []
        System.out.println(os.insert(1, "aaaaa")); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee")); // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(4, "ddddd")); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]

    }

}
