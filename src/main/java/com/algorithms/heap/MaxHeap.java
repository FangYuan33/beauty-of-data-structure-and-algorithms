package com.algorithms.heap;

import java.util.Arrays;

/**
 * 大顶堆代码示例
 * 用索引1来表示堆顶元素，空出索引0，那么子节点索引计算公式为 2i 和 2i + 1，根节点计算公式为 i / 2
 *
 * @author FangYuan
 * @since 2023-02-12 15:51:32
 */
public class MaxHeap {

    private final int[] nums;

    private int size;

    private final int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        nums = new int[capacity + 1];
        size = 0;
    }

    public int getMax() {
        if (size > 0) {
            return nums[1];
        }

        return -1;
    }

    /**
     * 插入执行的是自下而上的堆化
     * 将值放入堆底不断地和它的父节点比较值，大的话交换，小的话结束
     */
    public void insert(int num) {
        if (size < capacity) {
            size++;

            int numIndex = size;
            // 保存到堆底
            nums[numIndex] = num;

            // 自下而上堆化
            heapifyDownTop(numIndex, num);
        }
    }

    /**
     * 删除堆顶元素，先将对顶值与堆底值进行交换，然后执行自上而下的堆化
     */
    public void deleteMax() {
        if (size > 0) {
            doDeleteNum(1);
        }
    }

    public void deleteNum(int num) {
        if (size > 0) {
            for (int i = 1; i <= size; i++) {
                if (num == nums[i]) {
                    doDeleteNum(i);
                    break;
                }
            }
        }
    }

    private void doDeleteNum(int numIndex) {
        // 替换元素
        int num = nums[size];
        // 被删除元素
        int deleteNum = nums[numIndex];

        // 交换、删除
        swap(numIndex, size);
        nums[size--] = -1;

        if (deleteNum > num) {
            // 自上而下堆化
            heapifyTopDown(numIndex);
        } else {
            heapifyDownTop(numIndex, num);
        }
    }

    private void heapifyTopDown(int numIndex) {
        int num = nums[numIndex];
        // 找到该值的索引位置
        for (int leftIndex = 2 * numIndex, rightIndex = leftIndex + 1; leftIndex <= size;
             leftIndex = numIndex * 2, rightIndex = leftIndex + 1) {

            if (num < nums[leftIndex]) {
                swap(leftIndex, numIndex);
                numIndex = leftIndex;
            }
            if (rightIndex <= size && num < nums[rightIndex]) {
                swap(rightIndex, numIndex);
                numIndex = rightIndex;
            }
        }
    }

    private void heapifyDownTop(int numIndex, int num) {
        // 找到该索引的位置
        for (int i = numIndex / 2; i >= 1; i = i / 2) {
            if (num > nums[i]) {
                // 交换当前索引和i的位置
                swap(numIndex, i);
                numIndex = i;
            } else {
                break;
            }
        }
    }

    private void swap(int numIndex, int i) {
        int temp = nums[numIndex];
        nums[numIndex] = nums[i];
        nums[i] = temp;
    }

    public void print() {
        System.out.println("Max Heap values: " + Arrays.toString(nums));
    }
}

class Test {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);

        maxHeap.print();

        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.print();
        System.out.println(maxHeap.getMax());

        maxHeap.deleteMax();
        maxHeap.print();

        maxHeap.insert(5);
        maxHeap.print();
        maxHeap.insert(6);
        maxHeap.print();

        maxHeap.deleteNum(5);
        maxHeap.print();
    }
}
