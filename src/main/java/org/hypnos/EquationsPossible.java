package org.hypnos;


/**
 * 990. 等式方程的可满足性 - 并查集做法
 */
public class EquationsPossible {

    public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        for (int i = 0; i < 26; ++i)
            parents[i] = i;
        // 先处理等于的逻辑
        for (String equation : equations) {
            if (equation.charAt(1) == '=')
                union(parents, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }

        // 处理不等于的逻辑
        for (String equation : equations) {
            if (equation.charAt(1) == '!')
                if (find(parents, equation.charAt(0) - 'a')
                        == find(parents, equation.charAt(3) - 'a'))
                    return false;
        }
        return true;
    }

    private void union(int[] parents, int i, int j) {
        parents[find(parents, i)] = parents[find(parents, j)];
    }

    private int find(int[] parents, int i) {
        return parents[i] == i ? i : (parents[i] = find(parents, parents[i]));
    }

    public static void main(String[] args) {
        String[] equations = {"a==b","b!=a"};
        EquationsPossible equationsPossible = new EquationsPossible();
        System.out.println(equationsPossible.equationsPossible(equations));
    }
}
