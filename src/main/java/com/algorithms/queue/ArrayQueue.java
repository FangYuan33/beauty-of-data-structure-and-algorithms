package com.algorithms.queue;

/**
 * 用数组实现队列
 * 因为数组删除元素的时间复杂度为 O(n)，所以不适合来实现队列
 * 但是我们可以借助首尾指针，并把数组看作一个环来实现
 */
public class ArrayQueue {

    /**
     * 首尾指针
     */
    private int front = 0;
    private int tail = 0;

    /**
     * 数组中的有效的值数量
     */
    private int size = 0;

    /**
     * 保存数据的数组
     */
    private final int[] arrayQueue;

    public ArrayQueue(int capacity) {
        arrayQueue = new int[capacity];
    }

    public void offer(int num) {
        if (size == arrayQueue.length) {
            System.out.println("队列已满！！！");
        } else {
            size++;
            arrayQueue[tail] = num;

            // 超长后跑到数组的头重新开始
            tail = ++tail % arrayQueue.length;
        }
    }

    public int poll() {
        if (size == 0) {
            System.out.println("队列没有数据！！！");

            return -1;
        } else {
            size--;
            int result = arrayQueue[front];
            front = ++front % arrayQueue.length;

            return result;
        }
    }

}
