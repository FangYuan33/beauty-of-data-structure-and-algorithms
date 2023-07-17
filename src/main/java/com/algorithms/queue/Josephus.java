package com.algorithms.queue;

import java.util.Arrays;

/**
 * Josephus问题，创建大小为 N 的队列，从第一个元素开始，每 M 个让它出队
 *
 * @author FangYuan
 * @since 2023-07-17 14:37:05
 */
public class Josephus {

    public static void main(String[] args) {
        new Josephus().josephus(7, 2);
    }

    private void josephus(int n, int m) {
        int[] res = new int[n];
        int index = 0;

        int originM = m;
        // 初始化
        ArrayQueue<Integer> queue = initialQueue(n);
        while (!queue.isEmpty()) {
            m--;
            if (m == 0) {
                res[index++] = queue.poll();
                m = originM;
            } else {
                queue.offer(queue.poll());
            }
        }

        System.out.println(Arrays.toString(res));
    }

    private ArrayQueue<Integer> initialQueue(int n) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(n);
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        return queue;
    }
}
