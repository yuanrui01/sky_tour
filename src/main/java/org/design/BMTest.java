package org.design;

import java.util.Arrays;


/**
 * 简陋bm字符串匹配
 */
public class BMTest {

    private static final int SIZE = 256;

	/**
	 * 记录字符出现的最后位置
	 */
    private void generateBC(char[] b, int m, int [] bc) {
        Arrays.fill(bc, -1);
        for (int i = 0; i < m; ++i) {
            bc[b[i]] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		generateGS(b, m, suffix, prefix);
        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) {
                if (a[i+j] != b[j]) break;
            }
            if (j < 0) {
                return i;
            }
			int x = j - bc[a[i+j]];
			int y = 0;
			if (j < m - 1) {
				y = moveByGS(j, m, suffix, prefix);
			}
			// 每次移动好后缀和坏字符两种规则给出步数的最大值
            i = i + Math.max(x, y);
        }
        return -1;
    }

	/**
	 * 生成好后缀的对应表
	 */
	private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
		for (int i = 0; i < m; ++i) {
			suffix[i] = -1;
			prefix[i] = false;
		}
		for (int i = 0; i < m - 1; ++i) {
			int j = i;
			int k = 0;
			while (j >= 0 && b[j] == b[m-1-k]) {
				j--;
				k++;
				suffix[k] = j + 1;
			}
			if (j == -1) prefix[k] = true;
		}
	}

	/**
	 * 好后缀移动步数
	 */
	private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j;
		if (suffix[k] != -1) return j - suffix[k] + 1;
		for (int r = j + 2; r <= m - 1; ++r) {
			if (prefix[m - r]) {
				return r;
			}
		}
		return m;
	}

}
