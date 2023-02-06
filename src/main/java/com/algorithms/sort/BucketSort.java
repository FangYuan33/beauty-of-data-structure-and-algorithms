package com.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {1, 45, 32, 23, 22, 31, 47, 24, 4, 15};

        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 桶排序
     * 指定数据范围为0 - 50，分桶为5个，每10个数为一个桶
     */
    @SuppressWarnings("unchecked")
    private static void bucketSort(int[] nums) {
        // 声明5个桶
        ArrayList<Integer>[] buckets = new ArrayList[5];
        Arrays.fill(buckets, new ArrayList<Integer>());

        // 数组元素分桶
        intoBucket(buckets, nums);

        // 出桶
        outOfBucket(buckets, nums);
    }

    private static void intoBucket(ArrayList<Integer>[] buckets, int[] nums) {
        for (int num : nums) {
            int bucketIndex = num / 10;
            buckets[bucketIndex].add(num);
        }
    }

    private static void outOfBucket(ArrayList<Integer>[] buckets, int[] nums) {
        for (ArrayList<Integer> bucket : buckets) {
            // 先排序 再出桶
            bucket.sort(Comparator.comparingInt(x -> x));

            // 出桶覆盖原数组值
            int numsIndex = 0;
            for (Integer num : bucket) {
                nums[numsIndex++] = num;
            }
        }
    }
}
