package org.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LCR 036. 逆波兰表达式求值
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int p1 = stack.poll();
                    int p2 = stack.poll();
                    stack.push(p2 + p1);
                }
                case "-" -> {
                    int p1 = stack.poll();
                    int p2 = stack.poll();
                    stack.push(p2 - p1);
                }
                case "*" -> {
                    int p1 = stack.poll();
                    int p2 = stack.poll();
                    stack.push(p2 * p1);
                }
                case "/" -> {
                    int p1 = stack.poll();
                    int p2 = stack.poll();
                    stack.push(p2 / p1);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.poll();
    }
}
