package com.algorithms.hashmap;

/**
 * 特殊的Hash表: 位图
 *
 * @author FangYuan
 * @since 2023-02-11 11:21:26
 */
public class BitMap {
    // 每个字符是16位 用于表示16个数字的存在情况
    private final char[] bytes;

    // 数据量大小
    private final int bits;

    public BitMap(int bits) {
        this.bits = bits;
        this.bytes = new char[bits / 16 + 1];
    }

    public void set(int num) {
        if (num > bits) {
            return;
        }

        int byteIndex = num / 16;
        // 标记该数字在数组中存在
        bytes[byteIndex] |= (1 << num % 16);
    }

    public boolean get(int num) {
        if (num > bits) {
            return false;
        } else {
            int byteIndex = num / 16;

            return (bytes[byteIndex] & (1 << num % 16)) != 0;
        }
    }
}
class TestBitMap {
    public static void main(String[] args) {
        BitMap bitMap = new BitMap(16);
        for (int i = 1; i <= 15; i++) {
            bitMap.set(i);
        }

        for (int i = 1; i <= 16; i++) {
            System.out.println(i + ": " + bitMap.get(i));
        }
    }
}
