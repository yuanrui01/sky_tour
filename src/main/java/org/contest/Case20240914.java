package org.contest;

import java.util.*;

public class Case20240914 {

    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, health - grid.get(0).get(0)});
        int[][] vis = new int[m][n];
        vis[0][0] = health - grid.get(0).get(0);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], h = curr[2];
            if (i == m - 1 && j == n - 1 && h > 0) {
                return true;
            }
            for (int[] direction : directions) {
                int ni = i + direction[0];
                int nj = j + direction[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int newHealth = h - grid.get(ni).get(nj);
                    if (newHealth > 0 && newHealth > vis[ni][nj]) {
                        vis[ni][nj] = newHealth;
                        queue.offer(new int[]{ni, nj, newHealth});
                    }
                }
            }
        }
        return false;
    }

    // 生成所有长度为 k 的子序列的 OR 值
    private List<Integer> generateOrValues(int[] nums, int k) {
        List<Integer> orValues = new ArrayList<>();
        generateOrValuesHelper(nums, k, 0, 0, orValues);
        return orValues;
    }

    private void generateOrValuesHelper(int[] nums, int k, int start, int currentOr, List<Integer> orValues) {
        if (k == 0) {
            orValues.add(currentOr);
            return;
        }
        for (int i = start; i <= nums.length - k; i++) {
            generateOrValuesHelper(nums, k - 1, i + 1, currentOr | nums[i], orValues);
        }
    }

    public int maxValue(int[] nums, int k) {
        List<Integer> firstPart = generateOrValues(nums, k);
        List<Integer> secondPart = generateOrValues(nums, k);

        // 排序 OR 值列表
        Collections.sort(firstPart);
        Collections.sort(secondPart);

        int maxVal = Integer.MIN_VALUE;
        int i = 0, j = 0;

        // 双指针找最大 XOR 值
        while (i < firstPart.size() && j < secondPart.size()) {
            int or1 = firstPart.get(i);
            int or2 = secondPart.get(j);
            maxVal = Math.max(maxVal, or1 ^ or2);

            if (or1 < or2) {
                i++;
            } else {
                j++;
            }
        }

        return maxVal;
    }

    static class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public int query(int idx) {
            int maxVal = 0;
            while (idx > 0) {
                maxVal = Math.max(maxVal, tree[idx]);
                idx -= idx & (-idx);
            }
            return maxVal;
        }

        public void update(int idx, int val) {
            while (idx < tree.length) {
                tree[idx] = Math.max(tree[idx], val);
                idx += idx & (-idx);
            }
        }
    }

    public int maxPathLength(int[][] coordinates, int k) {
        int n = coordinates.length;

        // 1. 对 y 进行离散化
        Set<Integer> ySet = new HashSet<>();
        for (int[] coord : coordinates) {
            ySet.add(coord[1]);
        }
        List<Integer> sortedY = new ArrayList<>(ySet);
        Collections.sort(sortedY);
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < sortedY.size(); i++) {
            yMap.put(sortedY.get(i), i + 1); // 离散化后的 y 从 1 开始
        }

        // 保存原始索引
        int[][] originalCoordinates = new int[n][3]; // 记录坐标和原始位置
        for (int i = 0; i < n; i++) {
            originalCoordinates[i][0] = coordinates[i][0];
            originalCoordinates[i][1] = coordinates[i][1];
            originalCoordinates[i][2] = i; // 保存原始索引
        }

        // 2. 按照 x 升序排列，如果 x 相同则按 y 升序排列
        Arrays.sort(originalCoordinates, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // 3. 使用树状数组动态规划
        FenwickTree fenwickTree = new FenwickTree(sortedY.size());
        int[] dp = new int[n]; // 记录原始索引位置上的最大路径
        int result = 0;

        for (int i = 0; i < n; i++) {
            int x = originalCoordinates[i][0];
            int y = originalCoordinates[i][1];
            int originalIndex = originalCoordinates[i][2];
            int yIndex = yMap.get(y);

            // 查询树状数组，获取在 yIndex 之前的最大路径长度
            int maxLen = fenwickTree.query(yIndex - 1);
            dp[originalIndex] = maxLen + 1; // 以当前点为终点的最长路径长度
            fenwickTree.update(yIndex, dp[originalIndex]);

            // 如果是原始的 k 位置，则记录结果
            if (originalIndex == k) {
                result = dp[originalIndex];
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        List<List<Integer>> list =  List.of(List.of(0,1,0,0,0),
//                List.of(0,1,0,1,0), List.of(0,0,0,1,0));
//        List<List<Integer>> list =  List.of(List.of(1,1,1,1));
//        int h = 4;
        Case20240914 case20240914 = new Case20240914();
//        System.out.println(case20240914.findSafeWalk(list, h));

        int[] nums = {2, 6, 7};
        int k = 1;
        System.out.println(case20240914.maxValue(nums, k)); // 输出 5

//        // 示例 1
//        int[][] coordinates1 = {{3,1}, {2,2}, {4,1}, {0,0}, {5,3}};
//        int k1 = 1;
//        System.out.println(case20240914.maxPathLength(coordinates1, k1)); // 输出: 3
//
//        // 示例 2
//        int[][] coordinates2 = {{2,1}, {7,0}, {5,6}};
//        int k2 = 2;
//        System.out.println(case20240914.maxPathLength(coordinates2, k2)); // 输出: 2
    }
}
