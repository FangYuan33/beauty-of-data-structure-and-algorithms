package com.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {9, 3, 2, 5, 1, 6};

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 中位数基准数优化
        betterBase(nums, left, right);

        // 哨兵划分
        int partition = partition(nums, left, right);

        // 分别排序两个子数组
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    /**
     * 优化基准数选择，在最左元素、中间元素和最右元素中选取其中的中位数作为基准数
     * 基准数的索引为left，所以找到中位数后交换位置即可，若最左即为中位数则不做处理
     */
    private static void betterBase(int[] nums, int left, int right) {
        int mid = (left + right) / 2;

        // 异或 相同为0 不同为1，那么只要满足该数据比其中一个大其中一个小即为中位数
        if ((nums[right] < nums[mid]) ^ (nums[right] < nums[right])) {
            swap(nums, left, right);
        } else if ((nums[mid] < nums[left]) ^ (nums[mid] < nums[right])) {
            swap(nums, left, mid);
        }
    }

    /**
     * 哨兵划分
     */
    private static int partition(int[] nums, int left, int right) {
        // 以 nums[left] 作为基准数，并记录基准数索引
        int base = nums[left];
        int baseIndex = left;

        while (left < right) {
            while (left < right && nums[right] >= base)
                right--;             // 从右向左找首个小于基准数的元素
            while (left < right && nums[left] <= base)
                left++;              // 从左向右找首个大于基准数的元素
            swap(nums, left, right); // 交换这两个元素
        }
        swap(nums, baseIndex, left); // 将基准数交换到两子数组的分界线
        return left;                 // 返回基准数索引
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
