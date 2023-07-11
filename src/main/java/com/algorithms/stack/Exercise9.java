package com.algorithms.stack;

import java.util.Stack;

/**
 * 栈的练习第九题 补全丢失的做括号
 *
 * @author FangYuan
 * @since 2023-07-11 12:53:51
 */
public class Exercise9 {

    public static void main(String[] args) {
        System.out.println(new Exercise9().exercise9("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
    }

    private String exercise9(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] charArray = s.toCharArray();
        // 表达式的每个元素
        Stack<String> element = new Stack<>();
        // 操作符
        Stack<Character> operators = new Stack<>();

        for (char c : charArray) {
            if (c == ' ') {
                continue;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // 操作符入栈
                operators.push(c);
            } else if (c == ')') {
                // 右括号需要弹出两个表达式元素并拼接括号和操作符
                String value1 = element.pop();
                String value2 = element.pop();
                Character operator = operators.pop();

                // 合成新的表达式
                String newElement = "( " + value2 + " " + operator + " " + value1 + " )";
                element.push(newElement);
            } else {
                // 数字直接入栈
                element.push(String.valueOf(c));
            }
        }

        return element.pop();
    }
}
