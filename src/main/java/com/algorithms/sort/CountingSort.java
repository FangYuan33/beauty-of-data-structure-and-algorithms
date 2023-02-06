package com.algorithms.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        // 假设8个考生，分数的范围是0 - 5分，他们的分数为[2, 5, 3, 0, 2, 3, 0, 3]，排序这些学生的分数
        int[] students = new int[]{2, 5, 3, 0, 2, 3, 0, 3};

        // 计数排序
        countingSort(students);

        System.out.println(Arrays.toString(students));
    }

    private static void countingSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // 寻找数组中的最大值来以此定义max + 1个桶
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // 定义桶，索引范围即数组值的最大范围，每个桶中保存的是该数字出现的次数，计数排序的计数概念出现
        int[] bucket = new int[max + 1];
        Arrays.fill(bucket, 0);

        // 计算每个数的个数在桶中累加
        for (int num : nums) {
            bucket[num]++;
        }
        // 依次累加桶中的数，该数表示小于等于该索引值的数量
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        // 创建临时数组来保存排序结果值
        int[] res = new int[nums.length];
        // 倒序遍历原数组
        for (int i = nums.length - 1; i >= 0; i--) {
            // 根据桶中的 计数 找出该数的索引
            int index = bucket[nums[i]] - 1;
            // 根据索引在结果数组中赋值
            res[index] = nums[i];
            // 该数分配完成后，需要将桶中的计数数量-1
            bucket[nums[i]]--;
        }

        // 结果数组覆盖原数组
        System.arraycopy(res, 0, nums, 0, res.length);
    }
}
