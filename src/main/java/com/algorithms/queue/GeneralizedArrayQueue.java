package com.algorithms.queue;

import com.algorithms.CommonUtil;

/**
 * 可以指定删除最早插入的第K个元素
 * 数组实现
 *
 * @author FangYuan
 * @since 2023-07-17 15:04:37
 */
@SuppressWarnings("unchecked")
public class GeneralizedArrayQueue<Item> {

    public static void main(String[] args) {
        GeneralizedArrayQueue<Integer> queue = new GeneralizedArrayQueue<>(5);
        for (int i = 0; i < 5; i++) {
            queue.insert(i);
        }

        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));

        for (int i = 0; i < 5; i++) {
            queue.insert(i);
        }
        System.out.println(queue.delete(2));
    }

    private Item[] nums;

    private Integer head = 0;

    /**
     * 先赋值在移动
     */
    private Integer tail = 0;

    private int size = 0;

    public GeneralizedArrayQueue(int capacity) {
        nums = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Item val) {
        // 不允许加NULL
        if (val == null) {
            return;
        }
        // 先判断是否需要扩容
        if (size == nums.length) {
            CommonUtil.resize(nums);
        }

        // 把数组看成一个环
        nums[tail % nums.length] = val;
        tail++;
        size++;
    }

    public Item delete(int k) {
        if (isEmpty() || k <= 0) {
            return null;
        }

        int beginIndex = head;
        while (k > 1) {
            // 判断下一位是否为空，不为空说明有效需要跳过去，为空说明没值了k不变值变化指针
            if (nums[(beginIndex + 1) % nums.length] != null) {
                beginIndex++;
                k--;
            } else {
                beginIndex++;
            }
        }
        // 头被移除后找到之后的头
        if (nums[head] == null) {
            head = ++head % nums.length;
        }
        size--;

        Item res = nums[beginIndex % nums.length];
        nums[beginIndex % nums.length] = null;

        return res;
    }
}
