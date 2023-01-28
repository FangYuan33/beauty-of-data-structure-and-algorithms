package com.algorithms.binarysearch;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(BinarySearch.doubleClose(nums, 0) == BinarySearch.leftCloseRightOpen(nums, 0));
        System.out.println(BinarySearch.doubleClose(nums, 1) == BinarySearch.leftCloseRightOpen(nums, 1));
        System.out.println(BinarySearch.doubleClose(nums, 2) == BinarySearch.leftCloseRightOpen(nums, 2));
        System.out.println(BinarySearch.doubleClose(nums, 3) == BinarySearch.leftCloseRightOpen(nums, 3));
        System.out.println(BinarySearch.doubleClose(nums, 4) == BinarySearch.leftCloseRightOpen(nums, 4));
        System.out.println(BinarySearch.doubleClose(nums, 5) == BinarySearch.leftCloseRightOpen(nums, 5));
        System.out.println(BinarySearch.doubleClose(nums, 6) == BinarySearch.leftCloseRightOpen(nums, 6));
        System.out.println(BinarySearch.doubleClose(nums, 7) == BinarySearch.leftCloseRightOpen(nums, 7));
        System.out.println(BinarySearch.doubleClose(nums, 8) == BinarySearch.leftCloseRightOpen(nums, 8));
        System.out.println(BinarySearch.doubleClose(nums, 9) == BinarySearch.leftCloseRightOpen(nums, 9));
    }
}
