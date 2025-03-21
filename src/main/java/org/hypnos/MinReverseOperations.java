package org.hypnos;

import java.util.*;

/**
 * 2612. 最少翻转操作数
 */
public class MinReverseOperations {

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        Set<Integer> ban = new HashSet<>();
        for (int b : banned) {
            ban.add(b);
        }

        TreeSet<Integer>[] indices = new TreeSet[]{new TreeSet<>(), new TreeSet<>()};
        for (int i = 0; i < n; i++) {
            if (i != p && !ban.contains(i)) {
                indices[i % 2].add(i);
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[p] = 0; // 起点
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(p);
        while (!q.isEmpty()) {
            int i = q.poll();
            // indices[mn % 2] 中的从 mn 到 mx 的所有下标都可以从 i 翻转到
            int mn = Math.max(i - k + 1, k - i - 1);
            int mx = Math.min(i + k - 1, n * 2 - k - i - 1);
            TreeSet<Integer> set = indices[mn % 2];
            for (Iterator<Integer> it = set.tailSet(mn).iterator(); it.hasNext(); it.remove()) {
                int j = it.next();
                if (j > mx) {
                    break;
                }
                ans[j] = ans[i] + 1; // 移动一步
                q.offer(j);
            }
        }
        return ans;
    }
}
