package org.hypnos;


/**
 * 1298. 你能从盒子里获得的最大糖果数
 */
public class MaxCandies {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        int n = status.length;
        boolean[] curKeys = new boolean[n];
        for (int initialBox : initialBoxes) {
            setKeys(initialBox, status, keys, curKeys, containedBoxes);
        }

        for (int initialBox : initialBoxes) {
            ans += dfs(initialBox, status, candies, curKeys, containedBoxes);
        }
        return ans;
    }

    private void setKeys(int i, int[] status, int[][] keys, boolean[] curKeys, int[][] containedBoxes) {
        if (status[i] == 1 || curKeys[i]) {
            for (int key : keys[i]) {
                curKeys[key] = true;
            }
            for (int containedBox : containedBoxes[i]) {
                setKeys(containedBox, status, keys, curKeys, containedBoxes);
            }
        }
    }

    private int dfs(int i, int[] status, int[] candies, boolean[] hasKeys, int[][] containedBoxes) {
        int ans = 0;
        if (status[i] == 1 || hasKeys[i]) {
            ans += candies[i];
            for (int containedBox : containedBoxes[i]) {
                ans += dfs(containedBox, status, candies, hasKeys, containedBoxes);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] status = {1,0,1,0};
        int[] candies = {7,5,4,100};
        int[][] keys = {{},{},{1},{}};
        int[][] containedBoxes = {{1,2},{3},{},{}};
        int[] initialBoxes = {0};
        MaxCandies maxCandies = new MaxCandies();
        System.out.println(maxCandies.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}
