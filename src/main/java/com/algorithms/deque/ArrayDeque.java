package com.algorithms.deque;

import java.util.EmptyStackException;

/**
 * 基于数组实现的双向队列
 *
 * 仍然是取巧使用的环数组的思想
 */
public class ArrayDeque {

    /**
     * 用于存储队列元素的数组
     */
    private final int[] nums;

    /**
     * 头尾指针
     */
    private int front = 0;
    private int rear = 0;

    /**
     * 队列中目前有效的值
     */
    private int size = 0;

    public ArrayDeque(int capacity) {
        this.nums = new int[capacity];
    }

    public void offerFirst(int num) {
        if (size == capacity()) {
            System.out.println("队列已满");
            return;
        }

        size++;
        // 头指针先向头移动一位，越过头部后返回数组尾部
        front = (front - 1 + capacity()) % capacity();
        // 再向数组中赋值，这里与从尾部进行操作的方法需要区分
        // 尾部操作是先进行赋值，再进行指针移动，如果都是先赋值、再移动会产生值覆盖的情况
        nums[front] = num;
    }

    public void offerLast(int num) {
        if (size == capacity()) {
            System.out.println("队列已满");
            return;
        }

        size++;
        // 尾部操作先赋值
        nums[rear] = num;
        // 再向对尾移动一位
        rear = (rear + 1) % capacity();
    }

    public int pollFirst() {
        int num = peekFirst();

        // 队列头元素出队，头指针需要向尾移动一位
        front = (front + 1) % capacity();
        size--;

        return num;
    }

    public int pollLast() {
        int num = peekLast();

        // 队列尾元素出队，尾指针需要向前头一位
        rear = (rear - 1 + capacity()) % capacity();
        size--;

        return num;
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // 头指针所在的位置就是队列的头，直接返回该数值即可
        return nums[front];
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // 尾指针所在的位置是队列尾的后一位，这里需要向前移动一位
        return nums[(rear - 1 + capacity()) % capacity()];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return nums.length;
    }
}
