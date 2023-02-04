package com.algorithms.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {9, 3, 2, 5, 1, 6};

        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 选取未排序区间的基准数
            int base = nums[i];

            // 排序区间数若比基准数大，则后移，直到找到合适的位置插入
            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }
}
