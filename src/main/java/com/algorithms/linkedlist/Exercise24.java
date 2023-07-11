package com.algorithms.linkedlist;

/**
 * 链表习题24
 *
 * @author FangYuan
 * @since 2023-07-11 19:58:09
 */
public class Exercise24 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

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
