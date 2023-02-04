package com.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 2};

//        bubbleSort(nums);
//        System.out.println(Arrays.toString(nums));

        bubbleSortImprove(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    private static void bubbleSortImprove(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            // 优化标志位: 如果未发生交换则证明已经有序
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                // 比较并交换位置
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }
}
