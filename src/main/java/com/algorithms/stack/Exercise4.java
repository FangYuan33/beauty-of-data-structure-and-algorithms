package com.algorithms.stack;

import java.util.Stack;

/**
 * 栈的课后习题4，使用栈来判断有效括号
 * 左括号直接入栈，右括号出栈进行比较即可
 *
 * @author FangYuan
 * @since 2023-07-11 12:24:18
 */
public class Exercise4 {

    public static void main(String[] args) {
        System.out.println(new Exercise4().exercise4("[()]{}{[()()]()}"));
    }

    private boolean exercise4(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // 保存左括号
        Stack<Character> stack = new Stack<>();

        char[] values = s.toCharArray();
        for (char value : values) {
            if (value == '(' || value == '[' || value == '{') {
                stack.push(value);
            } else if (value == ')') {
                Character left = stack.pop();
                if (!left.equals('(')) {
                    return false;
                }
            } else if (value == ']') {
                Character left = stack.pop();
                if (!left.equals('[')) {
                    return false;
                }
            } else if (value == '}') {
                Character left = stack.pop();
                if (!left.equals('{')) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
