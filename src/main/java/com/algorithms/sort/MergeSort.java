package com.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 2};

        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 注意边界大小都在数组范围内
     */
    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        // 类似后续遍历
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        // 辅助数组
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);

        // 左数组 在辅助数组的范围
        int leftBegin = 0, leftEnd = mid - left;
        // 右数组 在辅助数组的范围
        int rightBegin = mid + 1 - left, rightEnd = right - left;

        // 在原数组的范围内直接借助左右数组覆盖
        for (int i = left; i <= right; i++) {
            // 左数组用完了直接赋值右数组
            if (leftBegin > leftEnd) {
                nums[i] = temp[rightBegin++];
            } else if (rightBegin > rightEnd || temp[leftBegin] <= temp[rightBegin]) {
                // 右数组用完了或者左数组数小
                nums[i] = temp[leftBegin++];
            } else {
                // 左右数组都没用完，但是左数组比较大
                nums[i] = temp[rightBegin++];
            }
        }
    }
}
