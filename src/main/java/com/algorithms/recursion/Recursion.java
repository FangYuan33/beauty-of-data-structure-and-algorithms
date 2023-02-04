package com.algorithms.recursion;

import java.util.HashMap;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(recursion(5));
    }

    /**
     * 爬台阶问题
     * <p>
     * 递推公式: f(n) = f(n - 1) + f(n - 2)
     * 终止条件: 爬到第1或第2阶台阶
     * <p>
     * 备忘录: 当计算5阶台阶时，会计算4阶台阶和3阶台阶，计算4阶台阶时还会计算3阶台阶，3阶台阶的计算是重复的
     * 所以我们可以依靠备忘录来解决重复计算的问题
     */
    private static int recursion(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = recursion(n - 1) + recursion(n - 2);
        map.put(n, res);

        return res;
    }

    // 备忘录
    private static final HashMap<Integer, Integer> map = new HashMap<>(16);
}
