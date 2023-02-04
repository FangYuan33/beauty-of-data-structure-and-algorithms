package com.algorithms.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 8, 5, 2, 9};

        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums) {
        // 循环n-1次即可
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            // 寻找最小值
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换位置
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
}
