package com.algorithms.linkedlist;

/**
 * 链表节点
 *
 * @author FangYuan
 * @since 2023-07-11 19:56:58
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
