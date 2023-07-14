package com.algorithms.bag;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * 随机背包，能够随机访问背包中的所有元素
 *
 * @author FangYuan
 * @since 2023-07-14 12:18:58
 */
@SuppressWarnings("unchecked")
public class RandomBag<Item> implements Iterable<Item> {

    public static void main(String[] args) {
        RandomBag<Integer> random = new RandomBag<>(5);

        for (int i = 0; i < 10; i++) {
            random.add(i);
        }

        Iterator<Integer> iterator = random.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private Item[] nums;

    private int size;

    public RandomBag(int capacity) {
        nums = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item val) {
        // 校验大小，并实现扩容
        resize();

        nums[size++] = val;
    }

    /**
     * 扩容操作，如果背包装满了那么把它变成当前大小的2倍
     */
    private void resize() {
        if (nums.length == size) {
            Item[] newNums = (Item[]) new Object[nums.length << 1];

            System.arraycopy(nums, 0, newNums, 0, nums.length);
            nums = newNums;
        }
    }


    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIteratorIterator(nums);
    }

    /**
     * 随机背包的迭代器
     */
    private class RandomBagIteratorIterator implements Iterator<Item> {

        private Item[] copyNums;

        int index = 0;

        public RandomBagIteratorIterator(Item[] nums) {
            this.copyNums = (Item[]) new Object[nums.length];
            System.arraycopy(nums, 0, copyNums, 0, nums.length);

            randomArray(copyNums);
        }

        /**
         * 随机打乱顺序
         */
        private void randomArray(Item[] copyNums) {
            for (int i = 0; i < copyNums.length; i++) {
                int randomIndex = StdRandom.uniform(0, copyNums.length - 1);

                // swap
                Item temp = copyNums[i];
                copyNums[i] = copyNums[randomIndex];
                copyNums[randomIndex] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return index < copyNums.length;
        }

        @Override
        public Item next() {
            return copyNums[index++];
        }
    }
}
