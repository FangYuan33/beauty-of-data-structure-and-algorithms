package com.algorithms.linkedlist;

/**
 * 链表课后练习27
 *
 * @author FangYuan
 * @since 2023-07-11 20:53:22
 */
public class Exercise27 {

    public static void main(String[] args) {
        ListNode node = ListNodeUtil.getFixLengthListNode(5, 9);
        System.out.println(new Exercise27().max(node));
    }

    /**
     * 在正整数链表中返回它们中的最大值
     */
    private int max(ListNode listNode) {
        if (listNode == null) {
            return 0;
        }

        int max = 0;
        while (listNode != null) {
            max = Math.max(listNode.val, max);
            listNode = listNode.next;
        }

        return max;
    }
}
