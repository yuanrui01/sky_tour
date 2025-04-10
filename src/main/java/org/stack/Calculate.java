package org.stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. 基本计算器
 */
public class Calculate {

    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        nums.push(0);
        s = s.replaceAll(" ", "");
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            char c = cs[i];
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    char op = ops.peek();
                    if (op != '(') {
                        cal(nums, ops);
                    } else {
                        ops.poll();
                        break;
                    }
                }
            } else {
                if (isNum(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && isNum(cs[j])) u = u * 10 + (int)(cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peek() != '(') cal(nums, ops);
                    ops.push(c);
                }
            }
        }
        while (!ops.isEmpty()) cal(nums, ops);
        return nums.pollLast();
    }

    private void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.poll();
        nums.add(op == '+' ? a + b : a - b);
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        String s = "-2+ 1";
        System.out.println(calculate.calculate(s));
    }
}
