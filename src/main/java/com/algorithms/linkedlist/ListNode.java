package com.algorithms.linkedlist;

/**
 * 链表节点
 *
 * @author FangYuan
 * @since 2023-07-11 19:56:58
 */
public class ListNode<Item> {

    public Item val;
    public ListNode<Item> next;

    public ListNode(Item val) {
        this.val = val;
    }

    ListNode(Item val, ListNode<Item> next) {
        this.val = val;
        this.next = next;
    }
}
