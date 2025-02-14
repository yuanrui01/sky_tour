package org.hypnos;


/**
 * 59. 螺旋矩阵 II
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        f(ans, n, 1, 0);
        return ans;
    }

    public void f(int[][] ans, int n, int num, int base) {
        for (int j = 0; j < n; ++j) ans[base][base + j] = num++;
        for (int i = 1; i < n; ++i) ans[base + i][base + n - 1] = num++;
        for (int j = base + n - 2; j >= base; --j) ans[base + n - 1][j] = num++;
        for (int i = base + n - 2; i >= base + 1; --i) ans[i][base] = num++;
        if (n - 2 >= 0) f(ans, n - 2, num, base + 1);
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int n = 3;
        System.out.println(generateMatrix.generateMatrix(n));
    }
}


