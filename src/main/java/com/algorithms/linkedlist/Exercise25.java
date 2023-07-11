package com.algorithms.linkedlist;

/**
 * 链表课后练习25
 *
 * @author FangYuan
 * @since 2023-07-11 20:11:28
 */
public class Exercise25 {

    public static void main(String[] args) {
        ListNode node1 = ListNodeUtil.getFixLengthListNode(5, 0);
        ListNode node2 = ListNodeUtil.getFixLengthListNode(5, 5);

        new Exercise25().insertAfter(node1, node2);

        ListNodeUtil.print(node1);
    }

    /**
     * 使第二个节点成为第一个节点的后继节点
     */
    public void insertAfter(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return;
        }

        // 保存下来 ListNode1 的后继节点，供插入到 ListNode2 的尾节点
        ListNode temp = listNode1.next;

        listNode1.next = listNode2;

        // 找到 listNode2 尾巴节点并拼接
        while (listNode2.next != null) {
            listNode2 = listNode2.next;
        }
        listNode2.next = temp;
    }
}
