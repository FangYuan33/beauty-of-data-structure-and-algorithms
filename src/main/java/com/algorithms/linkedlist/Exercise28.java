package com.algorithms.linkedlist;

import com.algorithms.ListNodeUtil;

/**
 * 链表课后练习28
 *
 * @author FangYuan
 * @since 2023-07-11 20:57:18
 */
public class Exercise28 {

    public static void main(String[] args) {
        ListNode<Integer> node = ListNodeUtil.getFixLengthListNode(5, 9);
        new Exercise28().max(node);

        System.out.println(max);
    }

    private static int max = 0;

    /**
     * 递归法解决27题
     */
    private void max(ListNode<Integer> node) {
        // 递归结束条件
        if (node == null) {
            return;
        }

        max = Math.max(max, node.val);
        max(node.next);
    }
}
