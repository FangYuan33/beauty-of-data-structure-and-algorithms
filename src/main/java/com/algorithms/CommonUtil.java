package com.algorithms;

/**
 * 公共工具类
 *
 * @author FangYuan
 * @since 2023-07-14 17:24:45
 */
@SuppressWarnings("unchecked")
public class CommonUtil {

    /**
     * 扩容操作，如果满了那么把它变成当前大小的2倍
     */
    public static <Item> Item[] resize(Item[] nums) {
        Item[] newNums = (Item[]) new Object[nums.length << 1];
        System.arraycopy(nums, 0, newNums, 0, nums.length);

        return newNums;
    }

    /**
     * 交换元素的位置
     */
    public static <Item> void swap(Item[] nums, int left, int right) {
        Item temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
