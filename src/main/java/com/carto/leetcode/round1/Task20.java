package com.carto.leetcode.round1;

import java.util.Stack;

public class Task20 {


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                Character a = stack.peek();
                if (isPair(a, s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isPair(Character a, Character b) {
        if (a == '(' && b == ')') return true;
        if (a == '[' && b == ']') return true;
        if (a == '{' && b == '}') return true;
        return false;
    }
}
