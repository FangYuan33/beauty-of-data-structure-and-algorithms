package com.algorithms.sort;

import java.util.Arrays;

public class HeapSort {

    /**
     * 要求数组从1开始保存数
     */
    public void heapSort(int[] nums) {
        // 判断数组中是否有数
        if (nums.length > 2) {
            // 先对数组进行建堆
            buildHeap(nums);

            // 不断地比较和交换位置来排序
            int heapTail = nums.length - 1;
            while (heapTail >= 1) {
                // 将最大值放到合适的位置
                swap(nums, 1, heapTail);
                heapTail--;
                // 重新堆化
                heapifyTopDown(nums, 1, heapTail);
            }
        }
    }

    private void buildHeap(int[] nums) {
        // 找到最后一个非叶子节点
        for (int index = (nums.length - 1) / 2; index >= 1; index--) {
            // 自上而下建堆
            heapifyTopDown(nums, index, nums.length - 1);
        }
    }

    /**
     * 自上而下堆化
     *
     * @param numIndex 执行堆化的数值索引
     * @param heapEnd  堆化停止的数组范围
     */
    private void heapifyTopDown(int[] nums, int numIndex, int heapEnd) {
        int num = nums[numIndex];
        // 找到该值的索引位置
        for (int leftIndex = 2 * numIndex, rightIndex = leftIndex + 1; leftIndex <= heapEnd;
             leftIndex = numIndex * 2, rightIndex = leftIndex + 1) {

            if (num < nums[leftIndex]) {
                swap(nums, leftIndex, numIndex);
                numIndex = leftIndex;
            }
            if (rightIndex <= heapEnd && num < nums[rightIndex]) {
                swap(nums, rightIndex, numIndex);
                numIndex = rightIndex;
            }
        }
    }

    private void swap(int[] nums, int numIndex, int i) {
        int temp = nums[numIndex];
        nums[numIndex] = nums[i];
        nums[i] = temp;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 5, 1, 6};

        new HeapSort().heapSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
