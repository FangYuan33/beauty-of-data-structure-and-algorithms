package com.algorithms.stack;

import java.util.Stack;

/**
 * 双栈法实现算术表达式计算
 *
 * @author FangYuan
 * @since 2023-07-10 20:15:35
 */
public class Evaluate {

    public static void main(String[] args) {
        System.out.println(new Evaluate().evaluate("(1 + (2 + 3) * (4 * 5)))"));
    }

    /**
     * 计算算术表达式的值
     *
     * @param expression eg: (1 + (2 + 3) * (4 * 5)))
     */
    private Double evaluate(String expression) {
        // 操作符
        Stack<Character> ops = new Stack<>();
        // 数值
        Stack<Double> vals = new Stack<>();

        // 左括号不处理，数值和操作符各入自己的栈，遇到左括号不处理，右括号则进行一轮计算
        char[] charArray = expression.toCharArray();
        for (char c : charArray) {
            if ('(' == c || ' ' == c) {
                continue;
            } else if ('+' == c || '-' == c || '*' == c || '/' == c) {
                ops.push(c);
            } else if (')' == c) {
                // 执行计算逻辑
                Double val1 = vals.pop();
                Double val2 = vals.pop();
                // 运算符
                Character op = ops.pop();

                if (op.equals('+')) {
                    vals.push(val1 + val2);
                } else if (op.equals('-')) {
                    vals.push(val2 - val1);
                } else if (op.equals('*')) {
                    vals.push(val1 * val2);
                } else if (op.equals('/')) {
                    vals.push(val2 / val1);
                }
            } else {
                vals.push(Double.parseDouble(String.valueOf(c)));
            }
        }

        return vals.pop();
    }
}
