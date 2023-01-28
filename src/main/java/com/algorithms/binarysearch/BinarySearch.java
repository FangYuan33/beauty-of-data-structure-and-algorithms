package com.algorithms.binarysearch;

public class BinarySearch {

    /**
     * 双闭区间写法
     * 即 left 和 right 指向的是数组的首元素和尾元素
     */
    public static int doubleClose(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 搜索区间为空时结束循环，即 left > right
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 左闭右开区间写法
     * 即 left 和 right 指向的事数组的首元素和 尾元素 + 1
     */
    public static int leftCloseRightOpen(int[] nums, int target) {
        int left = 0, right = nums.length;

        // 搜索区间为空时结束循环，左闭右开区间为空的条件是 left = right
        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
