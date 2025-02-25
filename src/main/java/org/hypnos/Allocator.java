package org.hypnos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2502. 设计内存分配器
 */
public class Allocator {

    private int[] mem;
    private int n;
    private Map<Integer, List<int[]>> map;

    public Allocator(int n) {
        this.n = n;
        mem = new int[n];
        map = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        int idx = 0;
        while (idx < n) {
            if (mem[idx] == 0) {
                int b = idx;
                int cnt = 1;
                if (size == 1) {
                    map.computeIfAbsent(mID, k -> new ArrayList<>()).add(new int[]{b, size});
                    for (int i = 0; i < size; ++i) {
                        mem[b+i] = mID;
                    }
                    return b;
                }
                while (idx + 1 < n && mem[idx+1] == 0) {
                    idx++;
                    cnt++;
                    if (cnt == size) {
                        map.computeIfAbsent(mID, k -> new ArrayList<>()).add(new int[]{b, size});
                        for (int i = 0; i < size; ++i) {
                            mem[b+i] = mID;
                        }
                        return b;
                    }
                }
            }
            idx++;
        }
        return -1;
    }

    public int freeMemory(int mID) {
        List<int[]> idxs = map.get(mID);
        if (idxs == null) return 0;
        int ans = 0;
        for (int[] idx : idxs) {
            int begin = idx[0];
            int len = idx[1];
            ans += len;
            for (int i = 0; i < len; ++i) {
                mem[begin + i] = 0;
            }
        }
        map.remove(mID);
        return ans;
    }

    public static void main(String[] args) {
        Allocator loc = new Allocator(10); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
        System.out.println(loc.allocate(1, 1)); // 最左侧的块的第一个下标是 0 。内存数组变为 [1, , , , , , , , , ]。返回 0 。
        System.out.println(loc.allocate(1, 2)); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
        System.out.println(loc.allocate(1, 3)); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
        System.out.println(loc.freeMemory(2)); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
        System.out.println(loc.allocate(3, 4)); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
        System.out.println(loc.allocate(1, 1)); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
        System.out.println(loc.allocate(1, 1)); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
        System.out.println(loc.freeMemory(1)); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
        System.out.println(loc.allocate(10, 2)); // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
        System.out.println(loc.freeMemory(7)); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
    }
}
