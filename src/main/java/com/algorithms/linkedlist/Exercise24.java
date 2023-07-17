package com.algorithms.linkedlist;

import com.algorithms.ListNodeUtil;

/**
 * 链表习题24
 *
 * @author FangYuan
 * @since 2023-07-11 19:58:09
 */
public class Exercise24 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtil.getFixLengthListNode(5, 0);

        ListNodeUtil.print(listNode1);

        new Exercise24().removeAfter(listNode1);

        ListNodeUtil.print(listNode1);
    }

    /**
     * 删除该链表的后一个节点
     */
    void removeAfter(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return;
        }

        // 有 >= 2个节点
        listNode.next = listNode.next.next;
    }
}
