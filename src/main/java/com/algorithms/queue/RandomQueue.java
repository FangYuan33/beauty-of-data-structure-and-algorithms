package com.algorithms.queue;

import com.algorithms.CommonUtil;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 支持随机访问的队列
 *
 * @author FangYuan
 * @since 2023-07-14 15:53:53
 */
@SuppressWarnings("unchecked")
public class RandomQueue<Item> {

    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>(10);
        for (int i = 0; i < 10; i++) {
            randomQueue.enqueue(i);
        }

        for (int i = 0; i < 15; i++) {
            System.out.println(randomQueue.dequeue());
        }

        for (int i = 0; i < 10; i++) {
            randomQueue.enqueue(i);
        }

        for (int i = 0; i < 15; i++) {
            System.out.println(randomQueue.dequeue());
        }
    }

    private Item[] nums;

    private int size = 0;

    public RandomQueue(int capacity) {
        nums = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item val) {
        if (size == nums.length) {
            nums = CommonUtil.resize(nums);
        }
        nums[size++] = val;
    }

    /**
     * 随机删除一个元素
     */
    public Item dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            // 交换到末位，并把它删除
            int index = StdRandom.uniform(0, size);
            CommonUtil.swap(nums, index, --size);

            return nums[size];
        }
    }

    /**
     * 随机返回一个元素
     */
    public Item sample() {
        if (isEmpty()) {
            return null;
        } else {
            return nums[StdRandom.uniform(0, size)];
        }
    }
}
