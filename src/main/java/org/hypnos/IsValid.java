package org.hypnos;


import java.util.*;

/**
 * 20. 有效的括号
 */
public class IsValid {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character top = stack.poll();
                if (c == ')' && top == '(' || c == '}' && top == '{' || c == ']' && top == '[') {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
